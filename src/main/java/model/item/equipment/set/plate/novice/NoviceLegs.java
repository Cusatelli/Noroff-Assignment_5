package model.item.equipment.set.plate.novice;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

public class NoviceLegs extends Armor {
    public NoviceLegs() {
        super("Novice Plate boots", 1, new Attributes(1, 0, 0, 1), Slot.Legs, Armor.Plate);
    }
}
