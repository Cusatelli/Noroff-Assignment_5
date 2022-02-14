package model.equipment;

public abstract class Armor extends Equipment {
    private int resistance;
    private Armor type;

    public Armor(String name, int level, int resistance, Slot slot, Armor type) {
        super(name, level, slot);
        this.resistance = resistance;
        this.type = type;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    @Override
    public String toString() {
        return "Equipment { " +
                "Name = '" + getName() + '\'' +
                ", Level = " + getLevel() +
                ", Slot = " + getSlot() +
                ", Resistance = " + this.resistance +
                " }";
    }

    public String prettyPrint() {
        return "{ " +
                "\n\t\t\tName = '" + getName() + '\'' +
                "\n\t\t\tLevel = " + getLevel() +
                "\n\t\t\tSlot = " + getSlot() +
                "\n\t\t\tResistance = " + this.resistance +
                "\n\t\t}";
    }
}
