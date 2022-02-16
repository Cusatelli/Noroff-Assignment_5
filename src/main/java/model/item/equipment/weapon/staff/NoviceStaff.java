package model.item.equipment.weapon.staff;

import model.item.equipment.Weapon;

/**
 * Staff extends Weapon.
 */
public class NoviceStaff extends Weapon {

    /**
     * Initialize Staff Weapon (Novice Level).
     */
    public NoviceStaff() {
        super("Novice Staff", 1, 10, 1, WeaponType.Staff);
    }
}
