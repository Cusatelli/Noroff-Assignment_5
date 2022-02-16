package controller;

import java.util.Scanner;

/**
 * Class handling user input.
 */
public class InputHandler {
    private static InputHandler instance = null;
    private Scanner scanner;

    private InputHandler() {}

    /**
     * Singleton
     * @return InputHandler.
     */
    public static InputHandler getInstance() {
        if(instance == null) {
            instance = new InputHandler();
        }
        return instance;
    }

    /**
     * Use Scanner to listen to user input from console.
     * @return integer input.
     */
    public int listen() {
        this.scanner = new Scanner(System.in);
        String input = this.scanner.nextLine();
        return parseInteger(input);
    }

    /**
     * Make sure input is a valid integer.
     * @param input user input.
     * @return integer.
     */
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
            return -1;
        }
    }
}
