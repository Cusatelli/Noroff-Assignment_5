package model.role;

import model.item.equipment.Equipment;
import model.item.equipment.Equipped;
import model.item.equipment.set.leather.Leather;
import model.item.equipment.weapon.bow.NoviceBow;
import model.stats.Attributes;
import model.stats.Stats;

public class Ranger {
    public static Stats Stats() {
        return new Stats(
                1,
                100,
                new Attributes(1, 7, 1, 0),
                new Attributes(1, 7, 1, 0), // Initialize to same as base.
                new Equipment.Armor[]{ Equipment.Armor.Leather, Equipment.Armor.Mail },
                new Equipment.Weapon[]{ Equipment.Weapon.Bow }
        );
    }

    public static Equipped Equipment() {
        return new Equipped(Leather.Novice.Set(), new NoviceBow());
    }
}
