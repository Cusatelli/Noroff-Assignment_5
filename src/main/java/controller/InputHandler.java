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

    public String listen() {
        this.scanner = new Scanner(System.in);
        return this.scanner.nextLine();
    }

    public void interpreter(String input) {
        switch (State.getInputState()) {
            case Menu ->  {
                int parsedInput = Integer.parseInt(input);
                // Handle input
                this.handleMenuInput(parsedInput);
            }
            case CreateCharacter -> {
                int parsedInput = Integer.parseInt(input);
                // Handle input
                this.handleCreateCharacterInput(parsedInput);
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
        Character player = Player.getInstance();
        switch (parsedInput) {
            case 1 -> {
                player.initialize(Role.Mage);
                player.setRole(Role.Mage);
            }
            case 2 -> {
                player.setRole(Role.Rogue);
            }
            case 3 -> {
                player.setRole(Role.Ranger);
            }
            case 4 -> {
                player.setRole(Role.Warrior);
            }
            default -> Display.options(State.Input.CreateCharacter);
        }
        Display.userSelectRole(player.getRole());
        Display.pressAnyKeyToContinue();
    }
}
