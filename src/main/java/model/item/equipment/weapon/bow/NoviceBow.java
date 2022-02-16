package model.item.equipment.weapon.bow;

import model.item.equipment.Weapon;

/**
 * Bow extends Weapon.
 */
public class NoviceBow extends Weapon {

    /**
     * Initialize Bow Weapon (Novice Level).
     */
    public NoviceBow() {
        super("Novice Bow", 1, 7, 1.4, WeaponType.Bow);
    }
}
