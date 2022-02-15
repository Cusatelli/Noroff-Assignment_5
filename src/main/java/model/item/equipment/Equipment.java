package model.item.equipment;

import model.character.Role;
import model.item.Item;

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

    @Override
    public String toString() {
        return "Equipment { " +
                "Name = '" + getName() + '\'' +
                ", Level = " + getLevel() +
                ", Slot = " + getSlot() +
                " }";
    }
}
