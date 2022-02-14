package model.role;

import model.equipment.Equipment;
import model.equipment.Equipped;
import model.equipment.mail.Mail;
import model.equipment.weapon.dagger.NoviceDagger;
import model.stats.Attributes;
import model.stats.Stats;

public class Rogue {
    public static Stats Stats() {
        return new Stats(
                1,
                100,
                new Attributes(2, 6, 1, 0),
                new Attributes(2, 6, 1, 0), // Initialize to same as base.
                new Equipment.Armor[]{ Equipment.Armor.Leather, Equipment.Armor.Mail },
                new Equipment.Weapon[]{ Equipment.Weapon.Dagger, Equipment.Weapon.Sword }
        );
    }

    public static Equipped Equipment() {
        return new Equipped(Mail.Novice.Set(), new NoviceDagger());
    }
}
