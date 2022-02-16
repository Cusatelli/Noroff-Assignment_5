package model.item.equipment.weapon.sword;

import model.item.equipment.Weapon;

/**
 * Sword extends Weapon.
 */
public class AdeptSword extends Weapon {

    /**
     * Initialize Sword Weapon (Adept Level).
     */
    public AdeptSword() {
        super("Adept Sword", 5, 9, 2.75, WeaponType.Sword);
    }
}