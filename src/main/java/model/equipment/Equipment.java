package model.equipment;

public abstract class Equipment {
    private String name;
    private int level;
    private Slot slot;

    enum Type {
        Axe,
        Bow,
        Daggers,
        Hammers,
        staffs,
        Swords,
        Wands
    }

    public Equipment(String name, int level, Slot slot) {
        this.name = name;
        this.level = level;
        this.slot = slot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    @Override
    public String toString() {
        return "Equipment { " +
                "Name = '" + name + '\'' +
                ", Level = " + level +
                ", Slot = " + slot +
                " }";
    }
}