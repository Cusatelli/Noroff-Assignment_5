package model.item.equipment.weapon;

import model.item.equipment.Weapon;

/**
 * Knuckles extends Weapon.
 */
public class Knuckles extends Weapon {

    /**
     * Initialize Knuckles Weapon (Novice Level).
     */
    public Knuckles() {
        super("Bare Knuckles", 1, 1, 5, WeaponType.Knuckles);
    }
}
