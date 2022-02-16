package model.role;

import model.item.equipment.Equipment;
import model.item.equipment.Equipped;
import model.item.equipment.set.nude.Nude;
import model.item.equipment.weapon.Knuckles;
import model.stats.Attributes;
import model.stats.Stats;

/**
 * Character Default Deprived Class (Playable Role).
 */
public class Deprived {

    /**
     * Initialize Default Deprived class (role) with unique stats.
     * @return Stats.
     */
    public static Stats Stats() {
        return new Stats(
                1,
                100,
                new Attributes(2, 2, 1, 0),
                new Attributes(2, 2, 1, 0), // Initialize to same as base.
                new Equipment.ArmorType[]{ Equipment.ArmorType.Nude },
                new Equipment.WeaponType[]{ Equipment.WeaponType.Knuckles }
        );
    }

    /**
     * Get Default Deprived class (role) unique Equipment (Nude & Knuckles).
     * @return Equipped equipment
     */
    public static Equipped Equipment() {
        return new Equipped(Nude.Deprived.Set(), new Knuckles());
    }
}
