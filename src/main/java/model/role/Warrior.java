package model.role;

import model.item.equipment.Equipment;
import model.item.equipment.Equipped;
import model.item.equipment.set.plate.Plate;
import model.item.equipment.weapon.axe.NoviceAxe;
import model.stats.Attributes;
import model.stats.Stats;

public class Warrior {
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

    public static Equipped Equipment() {
        return new Equipped(Plate.Novice.Set(), new NoviceAxe());
    }
}
