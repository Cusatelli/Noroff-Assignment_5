package model.role;

import model.equipment.Equipment;
import model.equipment.Equipped;
import model.equipment.plate.Plate;
import model.equipment.weapon.axe.NoviceAxe;
import model.stats.Attributes;
import model.stats.Stats;

public class Warrior {
    public static Stats Stats() {
        return new Stats(
                1,
                100,
                new Attributes(5, 2, 1, 0),
                new Attributes(5, 2, 1, 0), // Initialize to same as base.
                new Equipment.Armor[]{ Equipment.Armor.Mail, Equipment.Armor.Plate },
                new Equipment.Weapon[]{ Equipment.Weapon.Axe, Equipment.Weapon.Hammer, Equipment.Weapon.Sword }
        );
    }

    public static Equipped Equipment() {
        return new Equipped(Plate.Novice.Set(), new NoviceAxe());
    }
}
