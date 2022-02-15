package model.item.equipment.set.cloth.novice;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

public class NoviceLegs extends Armor {
    public NoviceLegs() {
        super("Novice Sandals", 1, new Attributes(0, 0, 2, 0), Slot.Legs, Armor.Cloth);
    }
}
