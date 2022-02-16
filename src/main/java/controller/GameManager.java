package controller;

import controller.units.NPC;
import controller.units.Player;
import controller.units.enemy.*;
import model.State;
import model.character.Enemy;
import model.character.Role;
import model.item.Item;
import model.item.equipment.Equipment;
import model.item.equipment.Slot;
import model.item.equipment.Weapon;
import view.Display;

/*
 * TODO: Separate code further into methods and classes.
 *  & break down switch statements...
 */
public class GameManager {
    private static GameManager instance = null;
    private InputHandler inputHandler = null;
    private Enemy enemy = null;
    private NPC npc = null;
    private Player player = null;
    private boolean isPlayerTurn; // true = Player | false = Enemy
    private int interactionState = -1;
    private int gameState = 0; // num 0-4 = Combat | num 5 = Interact

    enum CombatState {
        Escape, // Important that escape always is 0
        Attack,
        Heal,
        Stats,
        Inventory,
        Equipment;

        public static CombatState get(int index) {
            System.out.println(CombatState.values()[index]);
            return CombatState.values()[index];
        }
    }
    enum InteractState {
        Leave, // Important that leave always is 0
        Shop,
        Stats,
        Inventory,
        Equipment;

        public static InteractState get(int index) {
            return InteractState.values()[index];
        }
    }

    private GameManager() { }

    public static GameManager getInstance() {
        if(instance == null) { instance = new GameManager(); }
        return instance;
    }

    public void initialize(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
        this.enemy = null;
        this.npc = NPC.getInstance();
        this.player = Player.getInstance();
        this.isPlayerTurn = false;
    }

    public void handleUserInput() {
        switch (State.getInputState()) {
            case Menu -> {
                System.out.println(Display.MenuMenu());
                switch (this.listen()) {
                    case 1 -> State.setInputState(State.Input.Start);
                    case 0 -> State.setInputState(State.Input.Exit);
                }
            }
            case Start -> {
                // Start Menu View
                System.out.println(Display.StartMenu());
                switch (this.listen()) {
                    case 1 -> {
                        State.setInputState(State.Input.CreateCharacter);
                    }
                    case 2 -> {
                        System.out.println(Display.PlayingAsDeprived());
                        this.initializePlayer(Role.Deprived);
                        State.setInputState(State.Input.Game);
                    }
                    case 0 -> State.setInputState(State.Input.Exit);
                }
            }
            case CreateCharacter -> {
                // Create Character View
                System.out.println(Display.CreateCharacterMenu());
                switch (this.listen()) {
                    case 1 -> initializePlayer(Role.Mage);
                    case 2 -> initializePlayer(Role.Ranger);
                    case 3 -> initializePlayer(Role.Rogue);
                    case 4 -> initializePlayer(Role.Warrior);
                    case 5 -> initializePlayer(Role.Deprived);
                    case 0 -> State.setInputState(State.Input.Exit);
                }

                // Proceed
                State.setInputState(State.Input.Game);
            }
            case Game -> {
                if(this.player == null) {
                    State.setInputState(State.Input.Exit);
                    return;
                }

                switch (gameState) {
                    case 0, 1, 2 -> {
                        enemy = this.initializeEnemy(randomRange(0, 10));

                        // Speed determines who goes first in combat.
                        isPlayerTurn = enemy.getAttack().getSpeed() > player.getEquipment().getWeapon().getSpeed();

                        System.out.println(Display.EnemyIntroduction(enemy.getIntroduction()));
                        State.setInputState(State.Input.Combat);
                    }
                    case 3 -> {
                        // Initialize NPC each time they are encountered.
                        this.initializeNPC(Role.Rogue);
                        this.interactionState = -1;
                        this.isPlayerTurn = false; // Always let NPC start interaction
                        State.setInputState(State.Input.Interact);
                    }
                }
                gameState++;
                if(gameState > 5) { gameState = 0; }
            }
            case Combat -> {
                if(enemy == null) {
                    System.out.println(Display.EnemyNotFound());
                    State.setInputState(State.Input.Game);
                    this.handleUserInput();
                    return;
                }

                if(isPlayerTurn) {
                    System.out.println(Display.CombatMenu());
                    this.handlePlayerCombatState(listen());
                } else { // Enemy turn
                    this.handleEnemyCombatState();
                }
                this.isPlayerTurn = !this.isPlayerTurn;
            }
            case Interact -> {
                if(npc == null) {
                    System.out.println(Display.NPCNotFound());
                    State.setInputState(State.Input.Game);
                    this.handleUserInput();
                    return;
                }

                if(isPlayerTurn) {
                    System.out.println(Display.InteractMenu());
                    this.handlePlayerInteractionState(listen());

                } else { // NPC turn
                    this.handleNPCInteractState(this.interactionState);
                }
                this.isPlayerTurn = !this.isPlayerTurn;
            }
            case Exit -> System.exit(0);
            default -> System.exit(1);
        }
        this.handleUserInput(); // Recursive if not exit.
    }

    private void handleEnemyCombatState() {
        Weapon enemyAttack = this.enemy.getAttack();
        int enemyDamage = enemyAttack.getDamage();
        player.takeDamage(enemyDamage);
        System.out.println(Display.EnemyDealDamageToPlayer(enemy.getName(), enemyAttack.getName(), enemyDamage));
        System.out.println(Display.PlayerRemainingHealth(player.getHealth()));
        if(player.isDead()) {
            System.out.println(Display.PlayerVanquished(enemy.getName()));
            player = null;
            State.setInputState(State.Input.Game); // TODO -> State.Input.Game
            this.handleUserInput();
        }
    }

    private void handlePlayerCombatState(int option) {
        switch (CombatState.get(option)) {
            case Attack -> {
                int playerDamage = (int) player.getDamage();
                enemy.takeDamage(playerDamage);
                System.out.println(Display.PlayerDealDamageToEnemy(playerDamage, enemy.getName()));
                System.out.println(Display.EnemyRemainingHealth(enemy.getName(), enemy.getCurrentHealth()));
                if (enemy.isDead()) {
                    int silverReward = randomRange(1, player.getLevel());
                    int expReward = enemy.getExperience();
                    System.out.println(Display.EnemyVanquished(enemy.getName(), expReward, silverReward));
                    if(player.levelUp(expReward)) {
                        System.out.println(Display.PlayerLevelUp(this.player));
                    }

                    player.setSilver(player.getSilver() + silverReward);
                    enemy = null;

                    State.setInputState(State.Input.Game); // TODO -> State.Input.Game
                    this.handleUserInput();
                }
            }
            case Heal -> {
                Item healingItem = player.getFirstItemOfType(Item.ItemType.Healing);

                if(healingItem == null) {
                    System.out.println(Display.PlayerInventoryHealingItemNotFound());
                } else {
                    int heal = healingItem.getValue();
                    System.out.println(Display.PlayerHeal(heal));
                    if (heal > 5) System.out.println(Display.PlayerReplenishLowHeal());
                    else System.out.println(Display.PlayerReplenishHighHeal());

                    player.replenishHealth(randomRange(0, 10));
                    player.getInventory().remove(healingItem); // Remove item last.
                }
                this.handleUserInput();
            }
            case Stats -> {
                System.out.println(player.toString());
                this.handleUserInput();
            }
            case Inventory -> {
                System.out.println(Display.Inventory(player.getInventoryAsString(), player.getSilver()));
                this.handleUserInput();
            }
            case Equipment -> {
                System.out.println(player.getEquipment());
                this.handleUserInput();
            }
            case Escape -> {
                boolean isSuccessfulEscape = randomRange(0, 1) == 1;
                if(isSuccessfulEscape) {
                    System.out.println(Display.PlayerEscapeEnemySuccess(enemy.getName()));
                    State.setInputState(State.Input.Game); // TODO -> State.Input.Game
                } else {
                    System.out.println(Display.PlayerEscapeEnemyFail());
                    this.isPlayerTurn = !this.isPlayerTurn;
                    this.handleUserInput();
                }
            }
        }
    }

    private void handleNPCInteractState(int interactionState) {
        switch (interactionState) {
            case -1 -> System.out.println(Display.NPCIntroduction(npc.getIntroduction()));
            case 1 -> System.out.println(Display.NPCInteractStatePotion());
            case 2 -> System.out.println(Display.NPCInteractStateBread());
            case 3 -> System.out.println(Display.NPCInteractStateEquipment());
            case 4 -> System.out.println(Display.NPCInteractStateBack());
        }
    }

    private void handlePlayerInteractionState(int option) {
        switch (InteractState.get(option)) {
            case Shop -> {
                this.handleInteractShop();
                this.handleUserInput();
            }
            case Stats -> {
                System.out.println(player.toString());
                this.handleUserInput(); // Go back to top!
            }
            case Inventory -> {
                System.out.println(player.getInventoryAsString());
                System.out.println("1. Use\n2. Equip\n0. Back"); // TODO -> To Display
                switch (this.listen()) {
                    case 1 -> {
                        System.out.println("Heal..."); // TODO HEAL
                    }
                    case 2 -> {
                        Item equipmentItem = this.player.getFirstItemOfType(Item.ItemType.Equipment);
                        if(equipmentItem == null) {
                            System.out.println(Display.PlayerInventoryEquipmentItemNotFound());
                        } else {
                            this.player.getEquipment().set(equipmentItem);
                            this.player.getInventory().remove(equipmentItem);
                        }
                    }
                    case 0 -> {
                        this.handleUserInput();
                    }
                }
                this.handleUserInput(); // Go back to top!
            }
            case Equipment -> {
                System.out.println(player.getEquipment());
            }
            case Leave -> {
                State.setInputState(State.Input.Game); // TODO: State.setInputState(State.Input.Game);
                this.isPlayerTurn = false;
                this.handleUserInput();
            }
        }
    }

    private void handleInteractShop() {
        int silverBalance = player.getSilver();
        int potionPrice = 5;
        int foodPrice = 2;
        int equipmentPrice = 2 * player.getLevel();
        if(equipmentPrice > 10) equipmentPrice = 10;
        System.out.println(Display.InteractShopMenu(potionPrice, foodPrice, equipmentPrice, silverBalance));
        int interactOption = listen();
        switch (interactOption) {
            case 1 -> {
                if(silverBalance >= potionPrice) {
                    player.setSilver(player.getSilver() - potionPrice);
                    player.addItemToInventory(new Item("Potion", player.getLevel(), randomRange(0, 20), Item.ItemType.Healing));
                }
            }
            case 2 -> {
                if(silverBalance >= foodPrice) {
                    player.setSilver(player.getSilver() - foodPrice);
                    player.addItemToInventory(new Item("Bread", player.getLevel(), randomRange(5, 10), Item.ItemType.Healing));
                }
            }
            case 3 -> {
                if(silverBalance >= equipmentPrice) {
                    player.setSilver(player.getSilver() - equipmentPrice);

                    // Generate "Random" equipment based on level and role
                    Slot slot = Slot.get(randomRange(0, 3));
                    Role role = this.player.getRole();
                    Equipment equipment = null;
                    if(this.player.getLevel() >= 5) { equipment = Equipment.GetAdept(role, slot); }
                    else { equipment = Equipment.GetNovice(role, slot); }
                    System.out.println(equipment);
                    player.addItemToInventory(equipment);
                    //player.addItemToInventory(new Item("Unknown", player.getLevel(), -1, Item.ItemType.Equipment, player.getRole()));//, Slot.get(randomRange(0, Slot.values().length))));
                }
            }
            case 4 -> {
                System.out.println(player.getEquipment());
            }
            default -> {
                // Do nothing..
            }
        }
        System.out.println(Display.Inventory(player.getInventoryAsString(), player.getSilver()));
        interactionState = interactOption;
    }

    private void initializePlayer(Role role) {
        Player player = Player.getInstance();
        player.initialize(role);
        player.setRole(role);

        Display.PlayerSelectedRole(role);
    }

    private void initializeNPC(Role role) {
        npc.initialize(role);
        npc.setRole(role);
        npc.setIntroduction(
                "A shady figure emerges from the depths of the woods." +
                        "\nHe shakily asks you..." +
                        "\nW.. W.. Wanna.. Bu.. uy.. some wares?! *cough*" +
                        "\nKeh.. hehek.."
        );
    }

    private Enemy initializeEnemy(int randomRange) {
        int level = player.getLevel();
        switch (randomRange) {
            case 0, 1, 2, 3 -> { // 40%
                return new Crow("Frenzied Crow", 15 * level, 5 * level, 5 * level);
            }
            case 4, 5, 6 -> { // 30%
                return new Drowner("Bloated Drowner", 12 * level, 4 * level, 2 * level);
            }
            case 7, 8 -> { // 20%
                return new Mercenary("Drunken Mercenary", 17 * level, 6 * level, 7 * level);
            }
            case 9 -> { // 10%
                return new Goblin("Fiery Goblin", 20 * level, (int) (7.5 * level), 9 * level);
            }
            default -> { // & 10
                return new Rat("Sewer Rag", level, level, level);
            }
        }
    }

    private int randomRange(int min, int max) {
        int range = max - min + 1;
        return (int)(Math.random() * range) + min;
    }

    private int listen() {
        return this.inputHandler.listen();
    }
}
