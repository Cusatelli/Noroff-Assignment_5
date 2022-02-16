package model.item.equipment.set.leather.novice;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

/**
 * Novice Legs extending Armor.
 */
public class NoviceLegs extends Armor {

    /**
     * Novice Leather legs.
     */
    public NoviceLegs() {
        super("Novice Boots", 1, new Attributes(0, 2, 0, 0), Slot.Legs, ArmorType.Leather);
    }
}
