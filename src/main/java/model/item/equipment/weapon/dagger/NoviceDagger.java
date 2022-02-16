package model.item.equipment.weapon.dagger;

import model.item.equipment.Weapon;

/**
 * Dagger extends Weapon.
 */
public class NoviceDagger extends Weapon {

    /**
     * Initialize Dagger Weapon (Novice Level).
     */
    public NoviceDagger() {
        super("Novice Dagger", 1, 3, 3.4, WeaponType.Dagger);
    }
}
