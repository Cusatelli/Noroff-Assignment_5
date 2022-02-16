package model.item.equipment.weapon.bow;

import model.item.equipment.Weapon;

/**
 * Bow extends Weapon.
 */
public class AdeptBow extends Weapon {

    /**
     * Initialize Bow Weapon (Adept Level).
     */
    public AdeptBow() {
        super("Adept Bow", 5, 11, 2.25, WeaponType.Bow);
    }
}
