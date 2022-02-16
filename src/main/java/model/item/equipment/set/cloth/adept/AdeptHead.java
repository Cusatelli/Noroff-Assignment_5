package model.item.equipment.set.cloth.adept;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

/**
 * Adept Head extending Armor.
 */
public class AdeptHead extends Armor {

    /**
     * Adept Cloth Head.
     */
    public AdeptHead() {
        super("Adept Cap", 5, new Attributes(0, 0, 4, 1), Slot.Head, ArmorType.Cloth);
    }
}
