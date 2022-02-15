package model.item.equipment.set.cloth.adept;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

public class AdeptLegs extends Armor {
    public AdeptLegs() {
        super("Adept Sandals", 5, new Attributes(0, 0, 4, 1), Slot.Legs, ArmorType.Cloth);
    }
}
