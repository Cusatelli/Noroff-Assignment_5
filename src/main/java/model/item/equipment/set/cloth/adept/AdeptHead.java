package model.item.equipment.set.cloth.adept;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

public class AdeptHead extends Armor {
    public AdeptHead() {
        super("Adept Cap", 5, new Attributes(0, 0, 4, 1), Slot.Head, ArmorType.Cloth);
    }
}
