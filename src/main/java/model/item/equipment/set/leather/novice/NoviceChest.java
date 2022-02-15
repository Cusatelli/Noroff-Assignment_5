package model.item.equipment.set.leather.novice;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

public class NoviceChest extends Armor {
    public NoviceChest() {
        super("Novice Straps", 1, new Attributes(0, 2, 0, 0), Slot.Body, ArmorType.Leather);
    }
}
