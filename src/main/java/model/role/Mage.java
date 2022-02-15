package model.role;

import model.item.equipment.Equipment;
import model.item.equipment.Equipped;
import model.item.equipment.set.cloth.Cloth;
import model.item.equipment.weapon.staff.NoviceStaff;
import model.stats.Attributes;
import model.stats.Stats;

public class Mage {
    public static Stats Stats() {
        return new Stats(
                1,
                100,
                new Attributes(1, 1, 8, 0),
                new Attributes(1, 1, 8, 0), // Initialize to same as base.
                new Equipment.ArmorType[]{ Equipment.ArmorType.Cloth },
                new Equipment.WeaponType[]{ Equipment.WeaponType.Staff, Equipment.WeaponType.Wand }
        );
    }

    public static Equipped Equipment() {
        return new Equipped(Cloth.Novice.Set(), new NoviceStaff());
    }
}
