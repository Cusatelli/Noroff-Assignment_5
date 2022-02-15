package model.item.equipment.set.plate.adept;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

public class AdeptLegs extends Armor {
    public AdeptLegs() {
        super("Adept Plate boots", 5, new Attributes(2, 0, 0, 3), Slot.Legs, Armor.Plate);
    }
}
