package model.role;

import model.equipment.Equipment;
import model.equipment.Equipped;
import model.equipment.nude.Nude;
import model.equipment.weapon.Knuckles;
import model.stats.Attributes;
import model.stats.Stats;

public class Deprived {
    public static Stats Stats() {
        return new Stats(
                1,
                100,
                new Attributes(1, 1, 1, 0),
                new Attributes(1, 1, 1, 0), // Initialize to same as base.
                new Equipment.Armor[]{ Equipment.Armor.Nude },
                new Equipment.Weapon[]{ Equipment.Weapon.Knuckles }
        );
    }

    public static Equipped Equipment() {
        return new Equipped(Nude.Deprived.Set(), new Knuckles());
    }
}
