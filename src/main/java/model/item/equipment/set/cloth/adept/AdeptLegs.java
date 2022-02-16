package model.item.equipment.set.cloth.adept;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

/**
 * Adept Legs extending Armor.
 */
public class AdeptLegs extends Armor {

    /**
     * Adept Cloth Legs.
     */
    public AdeptLegs() {
        super("Adept Sandals", 5, new Attributes(0, 0, 4, 1), Slot.Legs, ArmorType.Cloth);
    }
}
