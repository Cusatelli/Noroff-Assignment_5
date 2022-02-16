package model.item.equipment.set.leather.novice;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

/**
 * Novice Head extending Armor.
 */
public class NoviceHead extends Armor {

    /**
     * Novice Leather Head.
     */
    public NoviceHead() {
        super("Novice Hood", 1, new Attributes(0, 2, 0, 0), Slot.Head, ArmorType.Leather);
    }
}
