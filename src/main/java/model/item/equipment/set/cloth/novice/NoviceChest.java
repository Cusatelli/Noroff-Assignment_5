package model.item.equipment.set.cloth.novice;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

/**
 * Novice Chest extending Armor.
 */
public class NoviceChest extends Armor {

    /**
     * Novice Cloth Chest.
     */
    public NoviceChest() {
        super("Novice Robe", 1, new Attributes(0, 0, 2, 0), Slot.Body, ArmorType.Cloth);
    }
}
