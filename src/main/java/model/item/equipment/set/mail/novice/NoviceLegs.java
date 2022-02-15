package model.item.equipment.set.mail.novice;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

public class NoviceLegs extends Armor {
    public NoviceLegs() {
        super("Novice Chain boots", 1, new Attributes(1, 1, 0, 1), Slot.Legs, ArmorType.Mail);
    }
}
