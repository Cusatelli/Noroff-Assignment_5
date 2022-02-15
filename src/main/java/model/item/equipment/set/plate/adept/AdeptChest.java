package model.item.equipment.set.plate.adept;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

public class AdeptChest extends Armor {
    public AdeptChest() {
        super("Adept Chestplate", 5, new Attributes(2, 0, 0, 3), Slot.Body, ArmorType.Plate);
    }
}
