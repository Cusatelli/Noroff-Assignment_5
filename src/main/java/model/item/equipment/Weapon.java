package model.item.equipment;

/**
 * Weapon class which a character unit can equip.
 */
public abstract class Weapon extends Equipment {
    private int damage;
    private final double speed;
    private WeaponType type;

    /**
     * Initialize Weapon.
     * @param name Weapon name.
     * @param level Weapon level. (Required level).
     * @param damage Weapon damage.
     * @param speed Weapon speed.
     * @param type WeaponType type, used to id which role it belongs to.
     */
    public Weapon(String name, int level, int damage, double speed, WeaponType type) {
        super(name, level, Slot.Weapon, null);
        this.damage = damage;
        this.speed = speed;
        this.type = type;
    }

    /**
     * Get Weapon damage.
     * @return damage.
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Set Weapon damage.
     * @param damage damage.
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * Get Weapon speed.
     * @return weapon speed.
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Get Weapon Type.
     * @return weapon type.
     */
    public WeaponType getWeaponType() {
        return type;
    }

    /**
     * Set Weapon Type.
     * @param type weapon type.
     */
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
                "\n\t\t\tDamage = " + this.damage +
                "\n\t\t}";
    }
}
