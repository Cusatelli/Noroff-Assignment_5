package model.item.equipment.set.cloth.novice;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

public class NoviceHead extends Armor {
    public NoviceHead() {
        super("Novice Cap", 1, new Attributes(0, 0, 2, 0), Slot.Head, ArmorType.Cloth);
    }
}
