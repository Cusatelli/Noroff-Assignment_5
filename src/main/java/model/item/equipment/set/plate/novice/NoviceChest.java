package model.item.equipment.set.plate.novice;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

public class NoviceChest extends Armor {
    public NoviceChest() {
        super("Novice Chestplate", 1, new Attributes(1, 0, 0, 1), Slot.Body, Armor.Plate);
    }
}
