package model.equipment;

public abstract class Weapon extends Equipment {
    private int damage;

    public Weapon(String name, int level, int damage) {
        super(name, level, Slot.Weapon);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "Equipment { " +
                "Name = '" + getName() + '\'' +
                ", Level = " + getLevel() +
                ", Slot = " + getSlot() +
                ", Damage = " + this.damage +
                " }";
    }

    public String prettyPrint() {
        return "{ " +
                "\n\t\t\tName = '" + getName() + '\'' +
                "\n\t\t\tLevel = " + getLevel() +
                "\n\t\t\tSlot = " + getSlot() +
                "\n\t\t\tDamage = " + this.damage +
                "\n\t\t}";
    }
}
