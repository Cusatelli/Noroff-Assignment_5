package model.item.equipment.set.leather.adept;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

public class AdeptChest extends Armor {
    public AdeptChest() {
        super("Adept Straps", 5, new Attributes(0, 3, 0, 2), Slot.Body, ArmorType.Leather);
    }
}
