package controller;

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
            return -1;
        }
    }
}
