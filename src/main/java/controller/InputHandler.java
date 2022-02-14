package controller;

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
                System.out.println("YOUR ADVENTURE BEGINS!");
                System.out.println(Player.getInstance().toString());
            }
            case Exit -> {
                System.exit(1);
            }
        }
    }

    private void handleMenuInput(int parsedInput) {
        switch (parsedInput) {
            case 1 -> {
                Display.options(State.Input.Start);
            }
            case 2 -> {
                State.setInputState(State.Input.CreateCharacter);
                Display.options(State.Input.CreateCharacter);
            }
            case 3 -> {
                State.setControllerState(State.Controller.Exit);
                Display.options(State.Input.Exit);
            }
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
            default -> Display.options(State.Input.CreateCharacter);
        }
    }

    private void handleInputByRole(Role role) {
        Character player = Player.getInstance();
        player.initialize(role);
        player.setRole(role);

        Display.userSelectRole(player.getRole());
        Display.pressAnyKeyToContinue();
    }
}
