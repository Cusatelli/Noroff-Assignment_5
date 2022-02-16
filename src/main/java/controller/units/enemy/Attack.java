package controller.units.enemy;

import model.item.equipment.Weapon;

/**
 * Attack extending Weapon used specifically by Enemies.
 */
public class Attack extends Weapon {

    /**
     * Initialize Attack
     * @param name attack name.
     * @param level attack level.
     * @param damage attack damage.
     * @param speed attack speed.
     * @param type attack type.
     */
    public Attack(String name, int level, int damage, double speed, WeaponType type) {
        super(name, level, damage, speed, type);
    }
}
