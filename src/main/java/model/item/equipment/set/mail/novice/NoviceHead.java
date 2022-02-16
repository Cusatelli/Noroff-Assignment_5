package model.item.equipment.set.mail.novice;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

/**
 * Novice Head extending Armor.
 */
public class NoviceHead extends Armor {

    /**
     * Novice Mail Head.
     */
    public NoviceHead() {
        super("Novice Chainguard", 1, new Attributes(1, 1, 0, 1), Slot.Head, ArmorType.Mail);
    }
}
