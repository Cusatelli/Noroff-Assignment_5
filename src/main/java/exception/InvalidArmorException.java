package exception;

import model.character.Role;
import model.item.equipment.Armor;

public class InvalidArmorException  extends Exception {
    public InvalidArmorException(String message) {
        super(message);
    }

    public InvalidArmorException(Role role, Armor armor) {
        super(role + " can not equip the armor " + armor.getName() + "!");
    }
}
