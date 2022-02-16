package model.item.equipment;

import model.character.Role;
import model.item.Item;
import model.item.equipment.set.cloth.Cloth;
import model.item.equipment.set.leather.Leather;
import model.item.equipment.set.mail.Mail;
import model.item.equipment.set.nude.Nude;
import model.item.equipment.set.plate.Plate;
import model.item.equipment.weapon.Knuckles;
import model.item.equipment.weapon.MasterKnuckles;
import model.item.equipment.weapon.axe.AdeptAxe;
import model.item.equipment.weapon.axe.NoviceAxe;
import model.item.equipment.weapon.bow.AdeptBow;
import model.item.equipment.weapon.bow.NoviceBow;
import model.item.equipment.weapon.dagger.AdeptDagger;
import model.item.equipment.weapon.dagger.NoviceDagger;
import model.item.equipment.weapon.staff.AdeptStaff;
import model.item.equipment.weapon.staff.NoviceStaff;

/**
 * Abstract class extending Item class used to create Equipment like Armor and Weapons.
 */
public abstract class Equipment extends Item {

    /**
     * All available Weapon Types.
     */
    public enum WeaponType {
        Knuckles,
        Axe,
        Bow,
        Dagger,
        Hammer,
        Staff,
        Sword,
        Wand
    }

    /**
     * All available Armor Types.
     */
    public enum ArmorType {
        Nude,
        Cloth,
        Leather,
        Mail,
        Plate
    }

    /**
     * Initialize Equipment.
     * @param name Equipment name.
     * @param level Equipment level.
     * @param slot Equipment slot.
     * @param role Character Role.
     */
    public Equipment(String name, int level, Slot slot, Role role) {
        super(name, level, -1, ItemType.Equipment, role, slot);
    }

    /**
     * Get Novice role specific Armor set or Weapon.
     * @param role specific character role.
     * @param slot equipment slot.
     * @return Equipment found.
     */
    public static Equipment GetNovice(Role role, Slot slot) {
        Armor armor;
        switch (role) {
            case Mage -> {
                if(slot == Slot.Weapon) return new NoviceStaff();
                armor = Cloth.Novice.Get(slot);
            }
            case Ranger -> {
                if(slot == Slot.Weapon) return new NoviceBow();
                armor = Mail.Novice.Get(slot);
            }
            case Rogue -> {
                if(slot == Slot.Weapon) return new NoviceDagger();
                armor = Leather.Novice.Get(slot);
            }
            case Warrior -> {
                if(slot == Slot.Weapon) return new NoviceAxe();
                armor = Plate.Novice.Get(slot);
            }
            default -> {
                if(slot == Slot.Weapon) return new Knuckles();
                armor = Nude.Deprived.Get(slot);
            }
        }
        return armor;
    }

    /**
     * Get Adept role specific Armor set or Weapon.
     * @param role specific character role.
     * @param slot equipment slot.
     * @return Equipment found.
     */
    public static Equipment GetAdept(Role role, Slot slot) {
        Armor armor;
        switch (role) {
            case Mage -> {
                if(slot == Slot.Weapon) return new AdeptStaff();
                armor = Cloth.Adept.Get(slot);
            }
            case Ranger -> {
                if(slot == Slot.Weapon) return new AdeptBow();
                armor = Mail.Adept.Get(slot);
            }
            case Rogue -> {
                if(slot == Slot.Weapon) return new AdeptDagger();
                armor = Leather.Adept.Get(slot);
            }
            case Warrior -> {
                if(slot == Slot.Weapon) return new AdeptAxe();
                armor = Plate.Adept.Get(slot);
            }
            default -> {
                if(slot == Slot.Weapon) return new MasterKnuckles();
                armor = Nude.Deprived.Get(slot);
            }
        }
        return armor;
    }

    @Override
    public String toString() {
        return "Equipment { " +
                "Name = '" + getName() + '\'' +
                ", Level = " + getLevel() +
                ", Slot = " + getSlot() +
                " }";
    }
}
