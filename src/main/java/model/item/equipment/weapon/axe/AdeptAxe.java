package model.item.equipment.weapon.axe;

import model.item.equipment.Weapon;

/**
 * Axe extends Weapon.
 */
public class AdeptAxe extends Weapon {

    /**
     * Initialize Axe Weapon (Adept Level).
     */
    public AdeptAxe() {
        super("Adept Axe", 5, 15, 1.65, WeaponType.Axe);
    }
}
