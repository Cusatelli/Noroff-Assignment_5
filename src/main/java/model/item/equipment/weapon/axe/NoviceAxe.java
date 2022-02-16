package model.item.equipment.weapon.axe;

import model.item.equipment.Weapon;

/**
 * Axe extends Weapon.
 */
public class NoviceAxe extends Weapon {

    /**
     * Initialize Axe Weapon (Novice Level).
     */
    public NoviceAxe() {
        super("Novice Axe", 1, 12, 0.8, WeaponType.Axe);
    }
}
