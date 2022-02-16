package exception;

import model.character.Role;
import model.item.equipment.Weapon;

/**
 * Exception to throw whenever a Weapon can not be set.
 */
public class InvalidWeaponException extends Exception {

    /**
     * Default exception to throw.
     * @param message custom exception message.
     */
    public InvalidWeaponException(String message) {
        super(message);
    }

    /**
     * Custom exception to throw.
     * @param role Role which can not equip weapon.
     * @param weapon weapon tried to be equipped.
     */
    public InvalidWeaponException(Role role, Weapon weapon) {
        super(role + " can not equip the weapon " + weapon.getName() + "!");
    }
}
