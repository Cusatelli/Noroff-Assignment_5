package view;

import model.character.Role;

public class Display {
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

    public static String Start() {
        return
                       BACKGROUND_COLOR_CYAN + COLOR_BLACK + "                     " + COLOR_RESET +
                "\n" + BACKGROUND_COLOR_CYAN + COLOR_BLACK + "         RPG         " + COLOR_RESET +
                "\n" + BACKGROUND_COLOR_CYAN + COLOR_BLACK + "      CHARACTER      " + COLOR_RESET +
                "\n" + BACKGROUND_COLOR_CYAN + COLOR_BLACK + "                     " + COLOR_RESET;
    }

    public static String MenuMenu() {
        return title("Main Menu") +
                "\n" + number(1) + ". Start" +
                "\n" + exit();
    }

    public static String StartMenu() {
        return title("Start") +
                "\n" + number(1) + ". Create Character" +
                "\n" + number(2) + ". Play as Deprived (Hard Mode)" +
                "\n" + exit();
    }

    public static String CreateCharacterMenu() {
        return title("Create Character") +
                title("--------------------") +
                title("Choose a Class") +
                "\n" + number(1) + ". " + Role.Mage +
                "\n" + number(2) + ". " + Role.Ranger +
                "\n" + number(3) + ". " + Role.Rogue +
                "\n" + number(4) + ". " + Role.Warrior +
                "\n" + number(5) + ". " + Role.Deprived +
                "\n" + exit();
    }

    public static String PlayerSelectedRole(Role role) {
        StringBuilder stringBuilder = new StringBuilder("You have selected the ");
        switch (role) {
            case Mage -> stringBuilder.append("Wise");
            case Rogue -> stringBuilder.append("Sneaky");
            case Ranger -> stringBuilder.append("Sly");
            case Warrior -> stringBuilder.append("Mighty");
        }
        stringBuilder.append(" ").append(role).append("!"); // -> (" " + role + "!");
        return stringBuilder.toString();
    }

    public static String EnemyNotFound() {
        return error("Enemy Not Found!");
    }

    public static String NPCNotFound() {
        return error("The NPC does not exists...");
    }

    public static String CombatMenu() {
        return title("Combat") +
                "\n" + number(1) + ". Attack" +
                "\n" + number(2) + ". Heal (use Healing item)" +
                "\n" + number(3) + ". Stats" +
                "\n" + number(4) + ". Inventory" +
                "\n" + flee(0);
    }

    public static String InteractMenu() {
        return title("Interact") +
                "\n" + number(1) + ". Shop" +
                "\n" + number(2) + ". Stats" +
                "\n" + number(3) + ". Inventory" +
                "\n" + leave(0);
    }

    public static String InteractShopMenu(int balance) {
        return title("Shop") +
                info("Silver: " + balance) +
                "\n" + number(1) + ". Potion" +
                "\n" + number(2) + ". Bread" +
                "\n" + number(3) + ". Equipment" +
                "\n" + number(0) + ". " + negative("Back");
    }

    public static String PlayingAsDeprived() {
        return button("Playing as Deprived", BACKGROUND_COLOR_BLUE, COLOR_BLACK, 50);
    }

    public static String PlayerDealDamageToEnemy(int damage, String name) {
        return title("Attack") +
                "\nYou deal " + negative(String.valueOf(damage)) + " damage to '" + negative(name) + "'";
    }

    public static String EnemyDealDamageToPlayer(String name, String attackName, int damage) {
        return title("Attack", BACKGROUND_COLOR_RED, COLOR_BLACK) +
                "\nThe enemy '" + negative(name) + "' attacks you with '" + negative(attackName) + "'" +
                " and deals " + negative(String.valueOf(damage)) + " damage.";
    }

    public static String EnemyRemainingHealth(String name, int health) {
        return "'" + negative(name) + "' remaining health: " + positive(String.valueOf(health));
    }

    public static String PlayerRemainingHealth(int health) {
        return "Remaining health: " + positive(String.valueOf(health));
    }

    public static String PlayerHeal(int heal) {
        return title("Heal") +
                "\nYou heal for " + positive(String.valueOf(heal)) + " health.";
    }

    public static String PlayerReplenishLowHeal() {
        return "You feel " + positive("greatly") + " replenished and ready for battle!";
    }

    public static String PlayerReplenishHighHeal() {
        return "You feel " + COLOR_YELLOW + "slightly" + COLOR_RESET + " replenished...";
    }

    public static String EnemyVanquished(String name, int silver, int experience) {
        return title("Victory!") +
                "\nYou have vanquished the enemy '" + negative(name) + "'!" +
                "\n" + info("       Rewards!       ") +
                "\n Silver:     " + positive(String.valueOf(silver)) +
                "\n Experience: " + positive(String.valueOf(experience)) + "\n";
    }

    public static String PlayerVanquished(String name) {
        return title("Game Over!", BACKGROUND_COLOR_RED, COLOR_BLACK) +
                "\nYou have been vanquished by '" + negative(name) + "'!";
    }

    public static String PlayerEscapeEnemySuccess(String name) {
        return info("  Successfully Fled!  ") +
                "\nYou have " + positive("successfully") + " escaped the '" + negative(name) + "'!";
    }

    public static String PlayerEscapeEnemyFail() {
        return info(" Unsuccessfully Fled! ") +
                "\n" + negative("Coward!") + " Get back in there and show me what you are made of!";
    }

    public static String NPCIntroduction(String introduction) {
        return introduction;
    }

    public static String NPCInteractStatePotion() {
        return "Wonderful " + conceal("*cough*") + " wonderful! S.. s.. splendid!";
    }

    public static String NPCInteractStateBread() {
        return "Keheh.. heh! Good choice adventurere... " + conceal("*cough*");
    }

    public static String NPCInteractStateEquipment() {
        return "Keheh ehheh " + conceal("*cough* *cough*") + ", O.. of course! O.. o.. only the finest for you! Keehehhe!";
    }

    public static String NPCInteractStateBack() {
        return "We.. We.. Well, make up " + conceal("*cough*") + " your mind.. Hmpf!";
    }

    public static String PlayerInventoryHealingItemNotFound() {
        return info("You're out of potions.");
    }

    /* ----- HELPER METHODS ----- */

    private static String title(String title) {
        return title(title, BACKGROUND_COLOR_GREEN, COLOR_BLACK);//+ BACKGROUND_COLOR_GREEN + COLOR_BLACK + build(title, 25) + COLOR_RESET;
    }

    private static String title(String title, String backgroundColor, String textColor) {
        return "\n" + backgroundColor + textColor + build(title, 25) + COLOR_RESET;
    }

    private static String error(String error) {
        return "\n" + BACKGROUND_COLOR_RED + COLOR_BLACK + build(error, 25) + COLOR_RESET;
    }

    private static String conceal(String dimmed) {
        return COLOR_BLACK + dimmed + COLOR_RESET;
    }

    private static String button(String buttonText) {
        return button(buttonText, BACKGROUND_COLOR_BLUE, COLOR_BLACK, 15);
    }

    private static String button(String buttonText, String backgroundColor, String color, int width) {
        return backgroundColor + color + build(buttonText, width) + COLOR_RESET;
    }

    private static String exit() {
        return number(0) + ". " + negative("Exit");
    }

    private static String flee(int num) {
        return number(num) + ". " + negative("Flee");
    }

    private static String leave(int num) {
        return number(num) + ". " + negative("Leave");
    }

    private static String number(int number) {
        return COLOR_YELLOW + number + COLOR_RESET;
    }

    private static String info(String infoText) {
        return "\n" + BACKGROUND_COLOR_YELLOW + COLOR_BLACK + " " + infoText + " " + COLOR_RESET;
    }

    private static String positive(String positive) {
        return COLOR_GREEN + positive + COLOR_RESET;
    }

    private static String negative(String negative) {
        return COLOR_RED + negative + COLOR_RESET;
    }

    private static String build(String str, int width) {
        int actual = width - str.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < actual; index++) {
            if(index == (actual) / 2) {
                stringBuilder.append(str);
            } else {
                stringBuilder.append(" ");
            }
        }

        return stringBuilder.toString();
    }

    public static String Inventory(String inventory, int silver) {
        return title("Inventory", BACKGROUND_COLOR_PURPLE, COLOR_BLACK) +
                "\n" + inventory +
                "\nSilver: " + number(silver);
    }
}
