package controller;

import controller.enemy.Boar;
import model.character.Character;
import model.character.Role;
import model.State;
import view.Display;

import java.util.Scanner;

public class InputHandler {
    private static InputHandler instance = null;
    private Scanner scanner;

    private InputHandler() {}

    public static InputHandler getInstance() {
        if(instance == null) {
            instance = new InputHandler();
        }
        return instance;
    }

    public int listen() {
        this.scanner = new Scanner(System.in);
        String input = this.scanner.nextLine();
        return parseInteger(input);
    }

    private int parseInteger(String input) {
        try {
            String trimmed = input.trim();
            if(trimmed.equals("S") || trimmed.equals("E")) {
                return -1;
            }
            int number = Integer.parseInt((trimmed));
            if(number < 0 || number > 10) {
                return -1;
            }

            return number;
        } catch (NumberFormatException notANumberError) {
            Display.invalidUserInput(input);
            return -1;
        }
    }

    public void interpreter(int input) {
        switch (State.getInputState()) {
            case Menu ->  {
                // Handle input
                this.handleMenuInput(input);
            }
            case CreateCharacter -> {
                // Handle input
                this.handleCreateCharacterInput(input);
                State.setInputState(State.Input.Start); // Update state to proceed.
            }
            case Start -> {
                int randomCase = randomRange(1, 2);
                this.handleStartInput(randomCase);
            }
            case Combat -> {
                this.handleCombatInput(input);
            }
            case Interact -> {
                System.out.println(
                        "1. Yes!" +
                        "\n2. No, beat it old man!" +
                        "\n0. Exit");
                this.handleInteractInput(input);
            }
            case Exit -> {
                System.exit(1);
            }
        }
    }

    private void handleInteractInput(int parsedInput) {
        switch (parsedInput) {
            case 1 -> {
                System.out.println("Wonderful!" +
                        "\nSplendid!" +
                        "\n...Keheh!" +
                        "\n... *cough* Ehrm, here for only 10 silver this magic potion will be yours!" +
                        "\n... ... What say you?"
                );
                System.out.println(
                        "\n1. Purchase" +
                        "\n2. Decline"
                );
                switch (listen()) {
                    case 1 -> {
                        System.out.println("The potion is just placebo.. typical!");
                        Player player = Player.getInstance();
                        int randomHeal = randomRange(0, 15);
                        player.replenishHealth(randomHeal);
                        System.out.println("...Yet you feel better." +
                                "\nYou heal for: " + randomHeal + "hp."
                        );
                        System.out.println(
                                "\nBye now! Thank you for you generosity! Keheheh! *cough*" +
                                "\nyes yes yes.. Very generous!"
                        );
                        System.out.println("The merchant disappears into the woods...");
                        State.setInputState(State.Input.Combat);
                    }
                    case 2 -> {
                        System.out.println("Gosh.. That was my best offer! I'll be back with more loot Adventurer!" +
                                "\nDon't worry... kehehee! *cough*"
                        );
                        System.out.println("The merchant disappears into the woods...");
                        State.setInputState(State.Input.Combat);
                    }
                }
            }
            case 2 -> {
                System.out.println("Oh... Hmmph... Rude!\nI will remember this... One day... yes...");
                System.out.println("The merchant disappears into the woods...");
                State.setInputState(State.Input.Combat);
            }
            case 0 -> {
                State.setControllerState(State.Controller.Exit);
            }
        }
    }

    private void handleMenuInput(int parsedInput) {
        switch (parsedInput) {
            case 1 -> {
                State.setInputState(State.Input.Start);
                Display.options(State.Input.Start);
            }
            case 2 -> {
                State.setInputState(State.Input.CreateCharacter);
                Display.options(State.Input.CreateCharacter);
            }
            case 0 -> handleExitInput();
            default -> Display.options(State.Input.Menu);
        }
    }

    private void handleCreateCharacterInput(int parsedInput) {
        switch (parsedInput) {
            case 1 -> {
                handleInputByRole(Role.Mage);
            }
            case 2 -> {
                handleInputByRole(Role.Rogue);
            }
            case 3 -> {
                handleInputByRole(Role.Ranger);
            }
            case 4 -> {
                handleInputByRole(Role.Warrior);
            }
            case 0 -> handleExitInput();
            default -> Display.options(State.Input.CreateCharacter);
        }
    }

    private void handleStartInput(int randomCase) {
        switch (randomCase) {
            case 1 -> {
                System.out.println("You have encountered a wild boar!!");
                State.setInputState(State.Input.Combat);
            }
            case 2 -> {
                System.out.println("A merchant appears from the woods...");
                System.out.println("H.. Hello Adventurer...\n...\nCan I interest you in some goods & trinkets?");
                State.setInputState(State.Input.Interact);
            }
            case 0 -> handleExitInput();
        }
    }

    private void handleCombatInput(int parsedInput) {
        Player player = Player.getInstance();
        Boar boar = Boar.getInstance();

        if(boar.getCurrentHealth() <= 0) {
            boar = boar.spawn(randomRange(30, 60), randomRange(4, 10));
        }

        switch (parsedInput) {
            case 1 -> { // Attack
                double damageDealt = player.getDamage();
                boar.takeDamage((int) Math.floor(damageDealt)); // Round up
                System.out.println("\nYou dealt " + damageDealt + " damage.");
                System.out.println("Boar health: " + boar.getCurrentHealth());
                if (boar.getCurrentHealth() <= 0) {
                    boar.die();
                    State.setInputState(State.Input.Start); // Exit combat
                    System.out.println("The boar has perished, well done " + player.getName() + "!");

                    player.levelUp(randomRange(boar.getDamage() / 2, boar.getMaxHealth() / 3));
                } else {
                    System.out.println("The Boar is weakened!");
                }

            }
            case 2 -> { // Heal
                int heal = 5;
                player.replenishHealth(heal);
                if (player.getHealth() >= player.getStats().getMaxHealth()) {
                    player.setHealth(player.getStats().getMaxHealth());
                }

                System.out.println("\nYou healed for " + heal + "hp");
                System.out.println("You feel replenished!");
            }
            case 3 -> { // Flee
                if(randomRange(0, 1) == 0) {
                    int penaltyDamage = 15;
                    player.takeDamage(penaltyDamage);
                    System.out.println("\nCOWARD, is this how you act in the face of danger?");
                    System.out.println("You have received a penalty for your cowardice." +
                            "\nGET BACK IN THERE!");
                    System.out.println("You took " + penaltyDamage + " damage...");
                } else {
                    System.out.println("You successfully fled the scene! The boar seems to have lost interest..." +
                            "\nLucky bastard!");
                    State.setInputState(State.Input.Start);
                }
            }
            case 0 -> handleExitInput();
        }

        if (boar.getCurrentHealth() > 0) {
            System.out.println("Current health " + player.getHealth() + "hp");
            System.out.println(
                    "\n1. Attack!" +
                    "\n2. Use Item" +
                    "\n3. Flee"
            );
        }
        int boarDamage = boar.getDamage();
        player.takeDamage(boarDamage);

        System.out.println("\nThe Boar attacks you and deals " + boarDamage + " damage");

        if(player.getHealth() <= 0) {
            player.die();
            State.setControllerState(State.Controller.Exit);
        }
    }

    private void handleInputByRole(Role role) {
        Character player = Player.getInstance();
        player.initialize(role);
        player.setRole(role);

        // Proceed
        State.setInputState(State.Input.Start);

        Display.userSelectRole(player.getRole());
        Display.pressAnyKeyToContinue();
    }

    private void handleExitInput() {
        State.setControllerState(State.Controller.Exit);
        Display.options(State.Input.Exit);
    }

    private int randomRange(int min, int max) {
        int range = max - min + 1;
        return (int)(Math.random() * range) + min;
    }
}
