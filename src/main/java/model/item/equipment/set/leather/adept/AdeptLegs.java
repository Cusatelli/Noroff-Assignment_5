package model.item.equipment.set.leather.adept;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

public class AdeptLegs extends Armor {
    public AdeptLegs() {
        super("Adept Boots", 5, new Attributes(0, 3, 0, 2), Slot.Legs, Armor.Leather);
    }
}
