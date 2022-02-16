package model.item.equipment.set.leather.adept;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

/**
 * Adept Legs extending Armor.
 */
public class AdeptLegs extends Armor {

    /**
     * Adept Leather Legs.
     */
    public AdeptLegs() {
        super("Adept Boots", 5, new Attributes(0, 3, 0, 2), Slot.Legs, ArmorType.Leather);
    }
}
