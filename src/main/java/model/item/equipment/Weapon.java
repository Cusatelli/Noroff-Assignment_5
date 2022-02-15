package model.item.equipment;

public abstract class Weapon extends Equipment {
    private int damage;
    private double speed;
    private WeaponType type;

    public Weapon(String name, int level, int damage, double speed, WeaponType type) {
        super(name, level, Slot.Weapon, null);
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

    public WeaponType getWeaponType() {
        return type;
    }

    public void setWeaponType(WeaponType type) {
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
