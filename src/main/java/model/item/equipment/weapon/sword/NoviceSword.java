package model.item.equipment.weapon.sword;

import model.item.equipment.Weapon;

/**
 * Sword extends Weapon.
 */
public class NoviceSword extends Weapon {

    /**
     * Initialize Sword Weapon (Novice Level).
     */
    public NoviceSword() {
        super("Novice Sword", 1, 6, 1.75, WeaponType.Sword);
    }
}