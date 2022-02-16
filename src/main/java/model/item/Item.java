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
    private Slot slot;

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

    public Item(String name, int level, int value, ItemType type, Role role, Slot slot) {
        this.name = name;
        this.level = level;
        this.value = value;
        this.type = type;
        this.role = role;
        this.slot = slot;
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

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
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
