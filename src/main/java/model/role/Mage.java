package model.role;

import model.equipment.Equipment;
import model.equipment.Equipped;
import model.equipment.cloth.Cloth;
import model.equipment.weapon.staff.NoviceStaff;
import model.stats.Attributes;
import model.stats.Stats;

public class Mage {
    public static Stats Stats() {
        return new Stats(
                1,
                100,
                new Attributes(1, 1, 8, 0),
                new Attributes(1, 1, 8, 0), // Initialize to same as base.
                new Equipment.Armor[]{ Equipment.Armor.Cloth },
                new Equipment.Weapon[]{ Equipment.Weapon.Staff, Equipment.Weapon.Wand }
        );
    }

    public static Equipped Equipment() {
        return new Equipped(Cloth.Novice.Set(), new NoviceStaff());
    }
}
