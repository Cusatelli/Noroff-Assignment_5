package model.item.equipment;

import model.stats.Attributes;

public abstract class Armor extends Equipment {
    private final Attributes attributes;
    private final ArmorType type;

    public Armor(String name, int level, Attributes attributes, Slot slot, ArmorType type) {
        super(name, level, slot, null);
        this.attributes = attributes;
        this.type = type;
    }

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
