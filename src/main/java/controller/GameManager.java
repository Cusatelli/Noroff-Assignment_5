package controller;

import controller.units.NPC;
import controller.units.Player;
import controller.units.enemy.*;
import model.State;
import model.character.Enemy;
import model.character.Role;
import model.item.Item;
import model.item.equipment.Armor;
import model.item.equipment.Equipment;
import model.item.equipment.Slot;
import model.item.equipment.Weapon;
import model.item.equipment.set.cloth.Cloth;
import model.item.equipment.set.leather.Leather;
import model.item.equipment.set.mail.Mail;
import model.item.equipment.set.nude.Nude;
import model.item.equipment.set.plate.Plate;
import model.item.equipment.weapon.Knuckles;
import model.item.equipment.weapon.MasterKnuckles;
import model.item.equipment.weapon.axe.AdeptAxe;
import model.item.equipment.weapon.axe.NoviceAxe;
import model.item.equipment.weapon.bow.AdeptBow;
import model.item.equipment.weapon.bow.NoviceBow;
import model.item.equipment.weapon.dagger.AdeptDagger;
import model.item.equipment.weapon.dagger.NoviceDagger;
import model.item.equipment.weapon.staff.AdeptStaff;
import model.item.equipment.weapon.staff.NoviceStaff;
import view.Display;

public class GameManager {
    private static GameManager instance = null;
    private InputHandler inputHandler = null;
    private Enemy enemy = null;
    private NPC npc = null;
    private Player player = null;
    private boolean isPlayerTurn; // true - Player, false - Enemy
    private int interactionState = -1;
    private int gameState = 0; // 0-4 Combat, 5 Interact

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
                this.handleUserInput(); // Recursive
            }
            case Start -> {
                // Start Menu View
                System.out.println(Display.StartMenu());
                switch (this.listen()) {
                    case 1 -> {
                        State.setInputState(State.Input.CreateCharacter);
                        this.handleUserInput(); // Recursive
                    }
                    case 2 -> {
                        System.out.println(Display.PlayingAsDeprived());
                        this.initializePlayer(Role.Deprived);
                        State.setInputState(State.Input.Game);
                        this.handleUserInput();
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
                this.handleUserInput();
            }
            case Game -> {
                if(this.player == null) {
                    State.setInputState(State.Input.Exit);
                    return;
                }

                //int randomStartingPoint = randomRange(0, 5); // 0, 10 = 10% chance to encounter merchant
                switch (gameState) {
                    case 0, 1, 2 -> {//, 3, 4 -> {
                        switch (randomRange(0, 10)) {
                            case 0, 1, 2, 3 -> { // 40%
                                enemy = new Crow("Frenzied Crow", 15 * player.getLevel(), 5 * player.getLevel(), 5 * player.getLevel());
                            }
                            case 4, 5, 6 -> { // 30%
                                enemy = new Drowner("Bloated Drowner", 12 * player.getLevel(), 4 * player.getLevel(), 2 * player.getLevel());
                            }
                            case 7, 8 -> { // 20%
                                enemy = new Mercenary("Drunken Mercenary", 17 * player.getLevel(), 6 * player.getLevel(), 7 * player.getLevel());
                            }
                            case 9 -> { // 10%
                                enemy = new Goblin("Fiery Goblin", 20 * player.getLevel(), (int) (7.5 * player.getLevel()), 9 * player.getLevel());
                            }
                            case 10 -> { // 10%
                                enemy = new Rat("Sewer Rat", player.getLevel(), player.getLevel(), player.getLevel());
                            }
                        }
                        // Speed determines who goes first in combat.
                        isPlayerTurn = enemy.getAttack().getSpeed() > player.getEquipment().getWeapon().getSpeed();

                        System.out.println(enemy.getIntroduction());
                        State.setInputState(State.Input.Combat);
                    }
                    case 3 -> {
                        // Initialize NPC each time they are encountered.
                        npc.initialize(Role.Rogue);
                        npc.setRole(Role.Rogue);
                        npc.setIntroduction(
                                "A shady figure emerges from the depths of the woods." +
                                "\nHe shakily asks you..." +
                                "\nW.. W.. Wanna.. Bu.. uy.. some wares?! *cough*" +
                                "\nKeh.. hehek.."
                        );

                        this.interactionState = -1;
                        this.isPlayerTurn = false; // Always let NPC start interaction
                        State.setInputState(State.Input.Interact);
                    }
                }
                gameState++;
                if(gameState > 5) { gameState = 0; }
                this.handleUserInput();
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
                    int option = listen();
                    switch (option) {
                        case 1 -> {
                            int playerDamage = (int) player.getDamage();
                            enemy.takeDamage(playerDamage);
                            System.out.println(Display.PlayerDealDamageToEnemy(playerDamage, enemy.getName()));
                            System.out.println(Display.EnemyRemainingHealth(enemy.getName(), enemy.getCurrentHealth()));
                            if (enemy.isDead()) {
                                int silverReward = randomRange(1, player.getLevel());
                                int expReward = enemy.getExperience();
                                System.out.println(Display.EnemyVanquished(enemy.getName(), expReward, silverReward));
                                player.levelUp(expReward);
                                player.setSilver(player.getSilver() + silverReward);
                                System.out.println(player.getSilver());
                                enemy = null;

                                State.setInputState(State.Input.Game); // TODO -> State.Input.Game
                                this.handleUserInput();
                            }
                        }
                        case 2 -> {
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
                        }
                        case 3 -> {
                            System.out.println(player.toString());
                            this.handleUserInput(); // Go back to top!
                        }
                        case 4 -> {
                            System.out.println(Display.Inventory(player.getInventoryAsString(), player.getSilver()));
                            this.handleUserInput(); // Go back to top!
                        }
                        case 5 -> {
                            System.out.println(player.getEquipment());
                            this.handleUserInput(); // Go back to top!
                        }
                        case 0 -> {
                            boolean isSuccessfulEscape = randomRange(0, 1) == 1;
                            if(isSuccessfulEscape) {
                                System.out.println(Display.PlayerEscapeEnemySuccess(enemy.getName()));
                                State.setInputState(State.Input.Game); // TODO -> State.Input.Game
                                this.handleUserInput();
                            } else {
                                System.out.println(Display.PlayerEscapeEnemyFail());
                                this.isPlayerTurn = !this.isPlayerTurn;
                                this.handleUserInput();
                            }
                        }
                    }
                    this.isPlayerTurn = !this.isPlayerTurn;
                } else { // Enemy turn
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
                    this.isPlayerTurn = !this.isPlayerTurn;
                    this.handleUserInput();
                }
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
                    int option = listen();
                    switch (option) {
                        case 1 -> {
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
                                        if(this.player.getLevel() >= 5) { equipment = this.getAdept(role, slot); }
                                        else { equipment = this.getNovice(role, slot); }
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
                            this.handleUserInput();
                        }
                        case 2 -> {
                            System.out.println(player.toString());
                            this.handleUserInput(); // Go back to top!
                        }
                        case 3 -> {
                            System.out.println(player.getInventoryAsString());
                            System.out.println("1. Use\n2. Equip\n0. Back");
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
                        case 4 -> {
                            System.out.println(player.getEquipment());
                        }
                        case 0 -> {
                            State.setInputState(State.Input.Game); // TODO: State.setInputState(State.Input.Game);
                            this.isPlayerTurn = false;
                            this.handleUserInput();
                        }
                    }
                } else { // NPC turn
                    switch (interactionState) {
                        case -1 -> System.out.println(Display.NPCIntroduction(npc.getIntroduction()));
                        case 1 -> System.out.println(Display.NPCInteractStatePotion());
                        case 2 -> System.out.println(Display.NPCInteractStateBread());
                        case 3 -> System.out.println(Display.NPCInteractStateEquipment());
                        case 4 -> System.out.println(Display.NPCInteractStateBack());
                    }
                }
                this.isPlayerTurn = !this.isPlayerTurn;
                this.handleUserInput();
            }
            case Exit -> System.exit(0);
            default -> {}
        }
    }

    private Equipment getAdept(Role role, Slot slot) {
        Armor armor = null;
        switch (role) {
            case Mage -> {
                if(slot == Slot.Weapon) return new AdeptStaff();
                armor = Cloth.Adept.Get(slot);
            }
            case Ranger -> {
                if(slot == Slot.Weapon) return new AdeptBow();
                armor = Mail.Adept.Get(slot);
            }
            case Rogue -> {
                if(slot == Slot.Weapon) return new AdeptDagger();
                armor = Leather.Adept.Get(slot);
            }
            case Warrior -> {
                if(slot == Slot.Weapon) return new AdeptAxe();
                armor = Plate.Adept.Get(slot);
            }
            default -> {
                if(slot == Slot.Weapon) return new MasterKnuckles();
                armor = Nude.Deprived.Get(slot);
            }
        }
        return armor;
    }

    private Equipment getNovice(Role role, Slot slot) {
        Armor armor = null;
        switch (role) {
            case Mage -> {
                if(slot == Slot.Weapon) return new NoviceStaff();
                armor = Cloth.Novice.Get(slot);
            }
            case Ranger -> {
                if(slot == Slot.Weapon) return new NoviceBow();
                armor = Mail.Novice.Get(slot);
            }
            case Rogue -> {
                if(slot == Slot.Weapon) return new NoviceDagger();
                armor = Leather.Novice.Get(slot);
            }
            case Warrior -> {
                if(slot == Slot.Weapon) return new NoviceAxe();
                armor = Plate.Novice.Get(slot);
            }
            default -> {
                if(slot == Slot.Weapon) return new Knuckles();
                armor = Nude.Deprived.Get(slot);
            }
        }
        return armor;
    }

    private int randomRange(int min, int max) {
        int range = max - min + 1;
        return (int)(Math.random() * range) + min;
    }

    private void initializePlayer(Role role) {
        Player player = Player.getInstance();
        player.initialize(role);
        player.setRole(role);

        Display.PlayerSelectedRole(role);
    }

    private int listen() {
        return this.inputHandler.listen();
    }
}
