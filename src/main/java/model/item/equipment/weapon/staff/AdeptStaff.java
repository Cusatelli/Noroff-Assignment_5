package model.item.equipment.weapon.staff;

import model.item.equipment.Weapon;

/**
 * Staff extends Weapon.
 */
public class AdeptStaff extends Weapon {

    /**
     * Initialize Staff Weapon (Adept Level).
     */
    public AdeptStaff() {
        super("Adept Staff", 5, 20, 1.24, WeaponType.Staff);
    }
}
