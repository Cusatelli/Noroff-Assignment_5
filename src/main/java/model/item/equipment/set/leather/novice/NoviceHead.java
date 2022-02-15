package model.item.equipment.set.leather.novice;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

public class NoviceHead extends Armor {
    public NoviceHead() {
        super("Novice Hood", 1, new Attributes(0, 2, 0, 0), Slot.Head, ArmorType.Leather);
    }
}
