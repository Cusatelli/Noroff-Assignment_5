package view;

import model.character.Role;
import model.State;

public class Display {
    private static Display instance = null;
    public static final String COLOR_RESET = "\u001B[0m";
    public static final String COLOR_BLACK = "\u001B[30m";
    public static final String COLOR_RED = "\u001B[31m";
    public static final String COLOR_GREEN = "\u001B[32m";
    public static final String COLOR_YELLOW = "\u001B[33m";
    public static final String COLOR_BLUE = "\u001B[34m";
    public static final String COLOR_PURPLE = "\u001B[35m";
    public static final String COLOR_CYAN = "\u001B[36m";
    public static final String COLOR_WHITE = "\u001B[37m";
    public static final String BACKGROUND_COLOR_BLACK = "\u001B[40m";
    public static final String BACKGROUND_COLOR_RED = "\u001B[41m";
    public static final String BACKGROUND_COLOR_GREEN = "\u001B[42m";
    public static final String BACKGROUND_COLOR_YELLOW = "\u001B[43m";
    public static final String BACKGROUND_COLOR_BLUE = "\u001B[44m";
    public static final String BACKGROUND_COLOR_PURPLE = "\u001B[45m";
    public static final String BACKGROUND_COLOR_CYAN = "\u001B[46m";
    public static final String BACKGROUND_COLOR_WHITE = "\u001B[47m";

    private Display() {}

    public static Display getInstance() {
        if(instance == null) {
            instance = new Display();
        }
        return instance;
    }

    public static void welcome() {
        System.out.println("Welcome to RPG Character Creator");
    }

    public static void options(State.Input state) {
        switch (state) {
            case Menu -> menu();
            case CreateCharacter -> createCharacter();
            case Start -> start();
            case Combat -> combat();
            case Interact -> interact();
            case Exit -> exit();
        }
    }

    private static void menu() {
        System.out.println("Press a number between " + number(0) + " - " + number(2) + ", and press " + button("Enter") +  " to confirm." +
                "\n" + number(1) + ". Start as Deprived" +
                "\n" + number(2) + ". Create new Character" +
                "\n" + number(0) + ". " + customColor(COLOR_RED, "Exit")
        );
    }

    private static void createCharacter() {
        System.out.println("Press a number between " + number(1) + " - " + number(4) + ", and press " + button("Enter") + " to confirm." +
                "\nChoose a role for your adventurer:" +
                "\n" + number(1) + ". Mage" +
                "\n" + number(2) + ". Rogue" +
                "\n" + number(3) + ". Ranger" +
                "\n" + number(4) + ". Warrior"
        );
    }

    private static void start() {
        System.out.println("Starting Adventure...");
    }

    private static void combat() {
        System.out.println("A wild Enemy(Math.random() * 10) has appeared!" +
                "\nYou took TakeDamage(enemy.damage())!!!"
        );
    }

    private static void interact() {
        System.out.println("Hello there, Player.getName()!" +
                "\nWe need your help to collect " + number(12) +" Apples before Morkenork destroys our village!" +
                "\nPlease adventurer, what say you?"
        );
    }

    private static void exit() {
        System.out.println("Thank you for playing Morkenorks inevitable downfall!");
    }

    public static void pressAnyKeyToContinue() {
        System.out.println(number(1) + ". Continue" +
                "\n" + number(0) + ". " + customColor(COLOR_RED, "Exit"));
    }

    public static void userSelectMage() {
        System.out.println("You have selected the Wise Mage!");
    }

    public static void userSelectRole(Role role) {
        StringBuilder stringBuilder = new StringBuilder("You have selected the ");
        switch (role) {
            case Mage -> stringBuilder.append("Wise");
            case Rogue -> stringBuilder.append("Sneaky");
            case Ranger -> stringBuilder.append("Sly");
            case Warrior -> stringBuilder.append("Mighty");
        }
        stringBuilder.append(" ").append(role).append("!"); // -> (" " + role + "!");
        System.out.println(stringBuilder);
    }

    public static void invalidUserInput(String input) {
        /*System.out.println("\nOops! '" + input + "' is not a valid input!" +
                "\nPlease try an integer! \uD83D\uDE0A\n"
        );*/
    }

    private static String number(int number) {
        return COLOR_YELLOW + number + COLOR_RESET;
    }

    private static String button(String buttonText) {
        return BACKGROUND_COLOR_BLUE + COLOR_BLACK + " " + buttonText + " " + COLOR_RESET;
    }

    private static String customColor(String color, String message) {
        return color + message + COLOR_RESET;
    }
}
