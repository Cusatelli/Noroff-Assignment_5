package model.item.equipment;

import model.stats.Attributes;

public abstract class Armor extends Equipment {
    private Attributes attributes;
    private Armor type;

    public Armor(String name, int level, Attributes attributes, Slot slot, Armor type) {
        super(name, level, slot);
        this.attributes = attributes;
        this.type = type;
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
                "\n\t\t\tSlot = " + getSlot() +
                "\n\t\t\tAttributes = " + this.attributes.prettyPrint() +
                "\n\t\t}";
    }
}
