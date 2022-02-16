package model.item.equipment;

import model.stats.Attributes;

/**
 * Armor abstract class extending abstract Equipment class.
 * Used to create Armors.
 */
public abstract class Armor extends Equipment {
    private final Attributes attributes; // Armor attributes. (Buff character).
    private final ArmorType type; // Armor type.

    /**
     * Initialize Armor.
     * @param name armor name.
     * @param level armor level.
     * @param attributes armor attributes.
     * @param slot armor slot.
     * @param type armor type.
     */
    public Armor(String name, int level, Attributes attributes, Slot slot, ArmorType type) {
        super(name, level, slot, null);
        this.attributes = attributes;
        this.type = type;
    }

    /**
     * Get Armor specific attributes.
     * @return Attributes.
     */
    public Attributes getAttributes() {
        return this.attributes;
    }

    @Override
    public String toString() {
        return "Equipment { " +
                "Name = '" + getName() + '\'' +
                ", Level = " + getLevel() +
                ", Slot = " + getSlot() +
                ", Attributes = " + this.attributes +
                " }";
    }

    public String prettyPrint() {
        return "{ " +
                "\n\t\t\tName = '" + getName() + '\'' +
                "\n\t\t\tLevel = " + getLevel() +
                "\n\t\t\tAttributes = " + this.attributes.toStringEquipment() +
                "\n\t\t}";
    }
}
