package model.item.equipment.weapon.dagger;

import model.item.equipment.Weapon;

/**
 * Dagger extends Weapon.
 */
public class AdeptDagger extends Weapon {

    /**
     * Initialize Dagger Weapon (Adept Level).
     */
    public AdeptDagger() {
        super("Adept Dagger", 5, 5, 4.9, WeaponType.Dagger);
    }
}
