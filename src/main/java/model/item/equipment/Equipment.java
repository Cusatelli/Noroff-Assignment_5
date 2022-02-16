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

public abstract class Equipment extends Item {
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

    public enum ArmorType {
        Nude,
        Cloth,
        Leather,
        Mail,
        Plate
    }

    public Equipment(String name, int level, Slot slot, Role role) {
        super(name, level, -1, ItemType.Equipment, role, slot);
    }

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
