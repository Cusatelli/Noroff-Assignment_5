package model.item.equipment;

public abstract class Weapon extends Equipment {
    private int damage;
    private double speed;
    private Weapon type;

    public Weapon(String name, int level, int damage, double speed, Weapon type) {
        super(name, level, Slot.Weapon);
        this.damage = damage;
        this.speed = speed;
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Weapon getType() {
        return type;
    }

    public void setType(Weapon type) {
        this.type = type;
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
