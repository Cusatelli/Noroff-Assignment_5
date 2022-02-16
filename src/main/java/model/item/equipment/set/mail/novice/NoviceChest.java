package model.item.equipment.set.mail.novice;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

/**
 * Novice Chest extending Armor.
 */
public class NoviceChest extends Armor {

    /**
     * Novice Mail Chest.
     */
    public NoviceChest() {
        super("Novice Chainmail", 1, new Attributes(1, 1, 0, 1), Slot.Body, ArmorType.Mail);
    }
}
