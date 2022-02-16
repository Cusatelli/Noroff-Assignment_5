package model.item.equipment.set.mail.adept;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

/**
 * Adept Head extending Armor.
 */
public class AdeptHead extends Armor {

    /**
     * Adept Mail Head.
     */
    public AdeptHead() {
        super("Adept Chainguard", 5, new Attributes(2, 2, 0, 2), Slot.Head, ArmorType.Mail);
    }
}
