package model.item;

import model.character.Role;
import model.item.equipment.Slot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    private Item item;

    @BeforeEach
    void setUp() {
        item = new Item("Item", 1, 1, Item.ItemType.Healing);
    }

    @Test
    void Name_SetName_GetName() {
        String name = "Item name";
        item.setName(name);
        String itemName = item.getName();

        assertEquals(name, itemName);
    }

    @Test
    void Level_SetFive_GetFive() {
        int level = 5;
        item.setLevel(level);
        int itemLevel = item.getLevel();

        assertEquals(level, itemLevel);
    }

    @Test
    void Value_SetFour_GetFour() {
        int value = 4;
        item.setValue(value);
        int itemValue = item.getValue();

        assertEquals(value, itemValue);
    }

    @Test
    void Type_SetEquipment_GetEquipment() {
        Item.ItemType type = Item.ItemType.Equipment;
        item.setType(type);
        Item.ItemType itemType = item.getType();

        assertEquals(type, itemType);
    }

    @Test
    void Role_SetRoleRogue_GetRoleRogue() {
        item = new Item("Armor", 1, 1, Item.ItemType.Equipment);
        Role role = Role.Rogue;
        item.setRole(role);
        Role itemRole = item.getRole();

        assertEquals(role, itemRole);
    }

    @Test
    void Slot_SetSlot_GetSlot() {
        Slot slot = Slot.Legs;
        item.setSlot(slot);
        Slot itemSlot = item.getSlot();

        assertEquals(slot, itemSlot);
    }
}