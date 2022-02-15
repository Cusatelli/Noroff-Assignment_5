package model.item.equipment.set.leather.novice;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

public class NoviceLegs extends Armor {
    public NoviceLegs() {
        super("Novice Boots", 1, new Attributes(0, 2, 0, 0), Slot.Legs, ArmorType.Leather);
    }
}
