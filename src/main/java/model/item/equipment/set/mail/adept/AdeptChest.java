package model.item.equipment.set.mail.adept;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

public class AdeptChest extends Armor {
    public AdeptChest() {
        super("Adept Chainmail", 5, new Attributes(2, 2, 0, 2), Slot.Body, ArmorType.Mail);
    }
}
