package model.role;

import model.item.equipment.Equipment;
import model.item.equipment.Equipped;
import model.item.equipment.set.nude.Nude;
import model.item.equipment.weapon.Knuckles;
import model.stats.Attributes;
import model.stats.Stats;

public class Deprived {
    public static Stats Stats() {
        return new Stats(
                1,
                100,
                new Attributes(2, 2, 1, 0),
                new Attributes(2, 2, 1, 0), // Initialize to same as base.
                new Equipment.Armor[]{ Equipment.Armor.Nude },
                new Equipment.Weapon[]{ Equipment.Weapon.Knuckles }
        );
    }

    public static Equipped Equipment() {
        return new Equipped(Nude.Deprived.Set(), new Knuckles());
    }
}
