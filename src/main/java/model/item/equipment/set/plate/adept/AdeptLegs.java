package model.item.equipment.set.plate.adept;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

/**
 * Adept Legs extending Armor.
 */
public class AdeptLegs extends Armor {

    /**
     * Adept Plate Legs.
     */
    public AdeptLegs() {
        super("Adept Plate boots", 5, new Attributes(2, 0, 0, 3), Slot.Legs, ArmorType.Plate);
    }
}
