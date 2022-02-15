package model.item.equipment.set.mail.adept;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

public class AdeptLegs extends Armor {
    public AdeptLegs() {
        super("Adept Chain boots", 5, new Attributes(2, 2, 0, 2), Slot.Legs, ArmorType.Mail);
    }
}
