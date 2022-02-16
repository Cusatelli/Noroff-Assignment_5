package model.item.equipment.set.mail.adept;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

/**
 * Adept Legs extending Armor.
 */
public class AdeptLegs extends Armor {

    /**
     * Adept Mail Legs.
     */
    public AdeptLegs() {
        super("Adept Chain boots", 5, new Attributes(2, 2, 0, 2), Slot.Legs, ArmorType.Mail);
    }
}
