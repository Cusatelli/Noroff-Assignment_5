package model.item;

import model.character.Role;
import model.item.equipment.Armor;
import model.item.equipment.Equipment;
import model.item.equipment.Slot;
import model.item.equipment.Weapon;
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

public class Item {
    private String name;
    private int level;
    private int value;
    private ItemType type;
    private Role role;

    public enum ItemType {
        Healing,
        Equipment
    }

    public Item(String name, int level, int value, ItemType type) {
        this.name = name;
        this.level = level;
        this.value = value;
        this.type = type;
        this.role = null;
    }

    public Item(String name, int level, int value, ItemType type, Role role) {
        this.name = name;
        this.level = level;
        this.value = value;
        this.type = type;
        this.role = role;
    }

    public Equipment revealEquipment() {
        if(type != ItemType.Equipment) {
            System.err.println("Can not reveal an item which is not hidden.");
            return null;
        }

        int random = (int)(Math.random() * 4 + 1);
        Slot equipmentSlot = Slot.get(random);
        switch (equipmentSlot) {
            case Head -> {
                if(this.level > 2 && this.level < 5) return getHead(role, 0);
                if(this.level >= 5) return getHead(role, 1);
            }
            case Body -> {
                if(this.level > 2 && this.level < 5) return getBody(role, 0);
                if(this.level >= 5) return getBody(role, 1);
            }
            case Legs -> {
                if(this.level > 2 && this.level < 5) return getLegs(role, 0);
                if(this.level >= 5) return getLegs(role, 1);
            }
            case Weapon -> {
                if(this.level > 2 && this.level < 5) return getWeapon(role, 0);
                if(this.level >= 5) return getWeapon(role, 1);
            }
        }
        return null;
    }

    private Armor getHead(Role role, int type) {
        if(role == Role.Deprived) { return Nude.Deprived.Head(); }

        if(type == 0) {
            if(role == Role.Mage) { return Cloth.Novice.Head(); }
            if(role == Role.Ranger) { return Leather.Novice.Head(); }
            if(role == Role.Rogue) { return Mail.Novice.Head(); }
            if(role == Role.Warrior) { return Plate.Novice.Head(); }
        } else {
            if(role == Role.Mage) { return Cloth.Adept.Head(); }
            if(role == Role.Ranger) { return Leather.Adept.Head(); }
            if(role == Role.Rogue) { return Mail.Adept.Head(); }
            if(role == Role.Warrior) { return Plate.Adept.Head(); }
        }

        return null;
    }

    private Armor getBody(Role role, int type) {
        if(role == Role.Deprived) { return Nude.Deprived.Body(); }

        if(type == 0) {
            if(role == Role.Mage) { return Cloth.Novice.Body(); }
            if(role == Role.Ranger) { return Leather.Novice.Body(); }
            if(role == Role.Rogue) { return Mail.Novice.Body(); }
            if(role == Role.Warrior) { return Plate.Novice.Body(); }
        } else {
            if(role == Role.Mage) { return Cloth.Adept.Body(); }
            if(role == Role.Ranger) { return Leather.Adept.Body(); }
            if(role == Role.Rogue) { return Mail.Adept.Body(); }
            if(role == Role.Warrior) { return Plate.Adept.Body(); }
        }

        return null;
    }

    private Armor getLegs(Role role, int type) {
        if(role == Role.Deprived) { return Nude.Deprived.Legs(); }

        if(type == 0) {
            if(role == Role.Mage) { return Cloth.Novice.Legs(); }
            if(role == Role.Ranger) { return Leather.Novice.Legs(); }
            if(role == Role.Rogue) { return Mail.Novice.Legs(); }
            if(role == Role.Warrior) { return Plate.Novice.Legs(); }
        } else {
            if(role == Role.Mage) { return Cloth.Adept.Legs(); }
            if(role == Role.Ranger) { return Leather.Adept.Legs(); }
            if(role == Role.Rogue) { return Mail.Adept.Legs(); }
            if(role == Role.Warrior) { return Plate.Adept.Legs(); }
        }

        return null;
    }

    private Weapon getWeapon(Role role, int type) {
        if(type == 0) {
            if(role == Role.Deprived) { return new Knuckles(); }
            if(role == Role.Mage) { return new NoviceStaff(); }
            if(role == Role.Ranger) { return new NoviceBow(); }
            if(role == Role.Rogue) { return new NoviceDagger(); }
            if(role == Role.Warrior) { return new NoviceAxe(); }
        } else {
            if(role == Role.Deprived) { return new MasterKnuckles(); }
            if(role == Role.Mage) { return new AdeptStaff(); }
            if(role == Role.Ranger) { return new AdeptBow(); }
            if(role == Role.Rogue) { return new AdeptDagger(); }
            if(role == Role.Warrior) { return new AdeptAxe(); }
        }

        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        if(role == null) {
            return name + " { " +
                    "Level = " + level +
                    ", Value = " + value +
                    ", Type = " + type +
                    " }";
        }
        return name + " { " +
                "Level = " + level +
                ", Type = " + type +
                ", Role = " + role +
                " }";
    }
}
