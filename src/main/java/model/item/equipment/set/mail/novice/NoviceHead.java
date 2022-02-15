package model.item.equipment.set.mail.novice;

import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.stats.Attributes;

public class NoviceHead extends Armor {
    public NoviceHead() {
        super("Novice Chainguard", 1, new Attributes(1, 1, 0, 1), Slot.Head, Armor.Mail);
    }
}
