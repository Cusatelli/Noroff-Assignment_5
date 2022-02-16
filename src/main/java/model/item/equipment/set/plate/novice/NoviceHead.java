package model.item.equipment.set.plate.novice;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

/**
 * Novice Head extending Armor.
 */
public class NoviceHead extends Armor {

    /**
     * Novice Plate Head.
     */
    public NoviceHead() {
        super("Novice Helmet", 1, new Attributes(1, 0, 0, 1), Slot.Head, ArmorType.Plate);
    }
}
