package model.role;

import model.item.equipment.Equipment;
import model.item.equipment.Equipped;
import model.item.equipment.set.plate.Plate;
import model.item.equipment.weapon.axe.NoviceAxe;
import model.stats.Attributes;
import model.stats.Stats;

/**
 * Character Warrior Class (Playable Role).
 */
public class Warrior {

    /**
     * Initialize Warrior class (role) with unique stats.
     * @return Stats.
     */
    public static Stats Stats() {
        return new Stats(
                1,
                100,
                new Attributes(5, 2, 1, 0),
                new Attributes(5, 2, 1, 0), // Initialize to same as base.
                new Equipment.ArmorType[]{ Equipment.ArmorType.Mail, Equipment.ArmorType.Plate },
                new Equipment.WeaponType[]{ Equipment.WeaponType.Axe, Equipment.WeaponType.Hammer, Equipment.WeaponType.Sword }
        );
    }

    /**
     * Get Rogue class (role) unique Equipment (Plate Armor & Axe Weapon).
     * @return Equipped equipment
     */
    public static Equipped Equipment() {
        return new Equipped(Plate.Novice.Set(), new NoviceAxe());
    }
}
