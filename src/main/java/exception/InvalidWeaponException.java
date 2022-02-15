package exception;

import model.character.Role;
import model.item.equipment.Weapon;

public class InvalidWeaponException extends Exception {
    public InvalidWeaponException(String message) {
        super(message);
    }

    public InvalidWeaponException(Role role, Weapon weapon) {
        super(role + " can not equip the weapon " + weapon.getName() + "!");
    }
}
