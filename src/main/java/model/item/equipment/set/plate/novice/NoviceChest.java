package model.item.equipment.set.plate.novice;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

/**
 * Novice Chest extending Armor.
 */
public class NoviceChest extends Armor {

    /**
     * Novice Plate Chest.
     */
    public NoviceChest() {
        super("Novice Chestplate", 1, new Attributes(1, 0, 0, 1), Slot.Body, ArmorType.Plate);
    }
}
