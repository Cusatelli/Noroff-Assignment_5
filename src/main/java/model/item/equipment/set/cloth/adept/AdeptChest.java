package model.item.equipment.set.cloth.adept;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

public class AdeptChest extends Armor {
    public AdeptChest() {
        super("Adept Robe", 5, new Attributes(0, 0, 4, 1), Slot.Body, ArmorType.Cloth);
    }
}
