package view;

import model.character.Role;
import model.State;

public class Display {
    private static Display instance = null;

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
        System.out.println("Press a number between 1 & 3, and press Enter to confirm." +
                "\n1. Start" +
                "\n2. Create Character" +
                "\n3. Exit"
        );
    }

    private static void createCharacter() {
        System.out.println("Press a number between 1 & 4, and press Enter to confirm." +
                "\nChoose a role for your adventurer:" +
                "\n1. Mage" +
                "\n2. Rogue" +
                "\n3. Ranger" +
                "\n4. Warrior"
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
                "\nWe need your help to collect 12 Apples before Morkenork destroys our village!" +
                "\nPlease adventurer, what say you?"
        );
    }

    private static void exit() {
        System.out.println("Thank you for playing Morkenorks inevitable failure!");
    }

    public static void pressAnyKeyToContinue() {
        System.out.println("Press ANY key to continue!");
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
        System.out.println("\nOops! '" + input + "' is not a valid input!" +
                "\nPlease try an integer! \uD83D\uDE0A\n"
        );
    }
}
