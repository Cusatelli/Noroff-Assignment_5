package model.item.equipment.set.plate.adept;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

public class AdeptHead extends Armor {
    public AdeptHead() {
        super("Adept Helmet", 5, new Attributes(2, 0, 0, 3), Slot.Head, ArmorType.Plate);
    }
}
