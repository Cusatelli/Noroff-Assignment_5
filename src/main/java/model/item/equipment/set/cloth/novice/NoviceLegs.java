package model.item.equipment.set.cloth.novice;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

/**
 * Novice Legs extending Armor.
 */
public class NoviceLegs extends Armor {

    /**
     * Novice Cloth legs.
     */
    public NoviceLegs() {
        super("Novice Sandals", 1, new Attributes(0, 0, 2, 0), Slot.Legs, ArmorType.Cloth);
    }
}
