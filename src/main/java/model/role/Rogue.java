package model.role;

import model.item.equipment.Equipment;
import model.item.equipment.Equipped;
import model.item.equipment.set.mail.Mail;
import model.item.equipment.weapon.dagger.NoviceDagger;
import model.stats.Attributes;
import model.stats.Stats;

/**
 * Character Rogue Class (Playable Role).
 */
public class Rogue {

    /**
     * Initialize Rogue class (role) with unique stats.
     * @return Stats.
     */
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

    /**
     * Get Rogue class (role) unique Equipment (Mail Armor & Dagger Weapon).
     * @return Equipped equipment
     */
    public static Equipped Equipment() {
        return new Equipped(Mail.Novice.Set(), new NoviceDagger());
    }
}
