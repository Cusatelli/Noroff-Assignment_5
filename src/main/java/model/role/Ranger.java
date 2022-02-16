package model.role;

import model.item.equipment.Equipment;
import model.item.equipment.Equipped;
import model.item.equipment.set.leather.Leather;
import model.item.equipment.weapon.bow.NoviceBow;
import model.stats.Attributes;
import model.stats.Stats;

/**
 * Character Ranger Class (Playable Role).
 */
public class Ranger {

    /**
     * Initialize Ranger class (role) with unique stats.
     * @return Stats.
     */
    public static Stats Stats() {
        return new Stats(
                1,
                100,
                new Attributes(1, 7, 1, 0),
                new Attributes(1, 7, 1, 0), // Initialize to same as base.
                new Equipment.ArmorType[]{ Equipment.ArmorType.Leather, Equipment.ArmorType.Mail },
                new Equipment.WeaponType[]{ Equipment.WeaponType.Bow }
        );
    }

    /**
     * Get Ranger class (role) unique Equipment (Leather Armor & Bow Weapon).
     * @return Equipped equipment
     */
    public static Equipped Equipment() {
        return new Equipped(Leather.Novice.Set(), new NoviceBow());
    }
}
