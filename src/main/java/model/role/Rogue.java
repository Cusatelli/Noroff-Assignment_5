package model.role;

import model.item.equipment.Equipment;
import model.item.equipment.Equipped;
import model.item.equipment.set.mail.Mail;
import model.item.equipment.weapon.dagger.NoviceDagger;
import model.stats.Attributes;
import model.stats.Stats;

public class Rogue {
    public static Stats Stats() {
        return new Stats(
                1,
                100,
                new Attributes(2, 6, 1, 0),
                new Attributes(2, 6, 1, 0), // Initialize to same as base.
                new Equipment.ArmorType[]{ Equipment.ArmorType.Leather, Equipment.ArmorType.Mail },
                new Equipment.WeaponType[]{ Equipment.WeaponType.Dagger, Equipment.WeaponType.Sword }
        );
    }

    public static Equipped Equipment() {
        return new Equipped(Mail.Novice.Set(), new NoviceDagger());
    }
}
