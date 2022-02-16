package exception;

import model.character.Role;
import model.item.equipment.Armor;

/**
 * Exception to throw whenever an Armor can not be set.
 */
public class InvalidArmorException extends Exception {

    /**
     * Default exception to throw.
     * @param message custom exception message.
     */
    public InvalidArmorException(String message) {
        super(message);
    }

    /**
     * Custom exception to throw.
     * @param role Role which can not equip armor.
     * @param armor armor tried to be equipped.
     */
    public InvalidArmorException(Role role, Armor armor) {
        super(role + " can not equip the armor " + armor.getName() + "!");
    }
}
