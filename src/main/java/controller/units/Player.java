package controller.units;

import model.character.Character;
import model.item.Item;
import model.item.equipment.Weapon;
import model.stats.Attributes;

import java.util.ArrayList;
import java.util.List;

public class Player extends Character {
    private static Player instance = null;
    private List<Item> inventory = new ArrayList<>();
    private int silver = 0;

    private Player() {
        super();
    }

    public static Player getInstance() {
        if(instance == null) { instance = new Player(); }
        return instance;
    }

    public double getDamage() {
        Weapon weapon =  this.getEquipment().getWeapon();
        double weaponDamage = (weapon.getDamage() * weapon.getSpeed());
        double statModifier = 0;
        Attributes calculatedAttr = calculateAttributes();
        switch (getRole()) {
            case Deprived -> statModifier = (calculatedAttr.getStrength() + calculatedAttr.getDexterity()) / 1.5;
            case Mage -> statModifier = calculatedAttr.getIntelligence();
            case Rogue, Ranger -> statModifier = calculatedAttr.getDexterity();
            case Warrior -> statModifier = calculatedAttr.getStrength();
        }

        return weaponDamage + (weaponDamage * (statModifier / 100));
    }

    private Attributes calculateAttributes() {
        Attributes base = getStats().getTotalAttributes();
        Attributes head = getEquipment().getHead().getAttributes();
        Attributes body = getEquipment().getBody().getAttributes();
        Attributes legs = getEquipment().getLegs().getAttributes();

        return new Attributes(
                base.getStrength() + head.getStrength() + body.getStrength() + legs.getStrength(),
                base.getDexterity() + head.getDexterity() + body.getDexterity() + legs.getDexterity(),
                base.getIntelligence() + head.getIntelligence() + body.getIntelligence() + legs.getIntelligence(),
                base.getResilience() + head.getResilience() + body.getResilience() + legs.getResilience()
        );
    }

    private static void setInstance(Player instance) {
        Player.instance = instance;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public Item getFirstItemOfType(Item.ItemType itemType) {
        for (Item item : this.inventory) {
            if(item.getType() == itemType) {
                return item;
            }
        }
        return null;
    }

    public String getInventoryAsString() {
        StringBuilder stringBuilder = new StringBuilder("Inventory {");
        for (Item item: inventory) {
            stringBuilder.append("\n\t").append(item);
        }
        stringBuilder.append("\n}");
        return stringBuilder.toString();
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public void addItemToInventory(Item item) {
        this.inventory.add(item);
    }

    public int getSilver() {
        return this.silver;
    }

    public void setSilver(int silver) {
        this.silver = silver;
    }

    @Override
    public String toString() {
        return "Character {" +
                "\n\tName = '" + this.getName() + '\'' +
                "\n\tRole = " + this.getRole() +
                "\n\tSilver = " + this.getSilver() +
                "\n\tStats = " + this.getStats().prettyPrint() +
                "\n\tEquipment = " + this.getEquipment().prettyPrint() +
                "\n\tInventory = " + this.getInventoryAsString() +
                "\n}";
    }
}
