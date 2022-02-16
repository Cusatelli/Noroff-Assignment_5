package model.item.equipment.set.leather.adept;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

/**
 * Adept Head extending Armor.
 */
public class AdeptHead extends Armor {

    /**
     * Adept Leather Head.
     */
    public AdeptHead() {
        super("Adept Hood", 5, new Attributes(0, 3, 0, 2), Slot.Head, ArmorType.Leather);
    }
}
