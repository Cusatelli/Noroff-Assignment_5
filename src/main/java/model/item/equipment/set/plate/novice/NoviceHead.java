package model.item.equipment.set.plate.novice;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

public class NoviceHead extends Armor {
    public NoviceHead() {
        super("Novice Helmet", 1, new Attributes(1, 0, 0, 1), Slot.Head, Armor.Plate);
    }
}
