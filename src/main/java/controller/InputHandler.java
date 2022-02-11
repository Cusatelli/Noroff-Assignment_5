package controller;

import exception.StateException;
import model.Options;
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

    public void interpreter(Options options) {
        switch (options) {
            case Menu -> {
                Display.options(options);
                int input = Integer.parseInt(this.listen());
                while (input < 4 && input > 0) {
                    switch (input) {
                        case 1 -> {
                            System.out.println("You have selected Start!");
                            return;
                        }
                        case 2 -> {
                            System.out.println("You have selected Create Character!");
                            return;
                        }
                        case 3 -> {
                            System.out.println("You have selected Exit!");
                            return;
                        }
                        default -> {
                            input = Integer.parseInt(this.listen()); // Try again
                        }
                    }
                }
            }
            case CreateCharacter -> {}
            case Start -> {}
            case Combat -> {}
            case Interact -> {}
            case Exit -> {}
            default -> {
                try { throw new StateException(options, getClass()); }
                catch (StateException e) { e.printStackTrace(); }
            }
        }
    }
}
