package model.item.equipment.set.leather.adept;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

/**
 * Adept Chest extending Armor.
 */
public class AdeptChest extends Armor {

    /**
     * Adept Leather Chest.
     */
    public AdeptChest() {
        super("Adept Straps", 5, new Attributes(0, 3, 0, 2), Slot.Body, ArmorType.Leather);
    }
}
