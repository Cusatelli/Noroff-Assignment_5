package model.item.equipment.set.cloth.novice;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

/**
 * Novice Head extending Armor.
 */
public class NoviceHead extends Armor {

    /**
     * Novice Cloth Head.
     */
    public NoviceHead() {
        super("Novice Cap", 1, new Attributes(0, 0, 2, 0), Slot.Head, ArmorType.Cloth);
    }
}
