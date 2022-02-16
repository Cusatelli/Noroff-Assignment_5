package model.item.equipment.set.mail.novice;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

/**
 * Novice Legs extending Armor.
 */
public class NoviceLegs extends Armor {

    /**
     * Novice Mail legs.
     */
    public NoviceLegs() {
        super("Novice Chain boots", 1, new Attributes(1, 1, 0, 1), Slot.Legs, ArmorType.Mail);
    }
}
