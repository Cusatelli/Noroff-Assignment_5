package model.item.equipment;

import model.character.Role;
import model.item.equipment.set.plate.Plate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentTest {

    @Test
    void GetAdept_WarriorBodyAdeptArmor() {
        Role role = Role.Warrior;
        Slot slot = Slot.Body;
        Equipment equipment = Equipment.GetAdept(role, slot);
        String equipmentName = equipment.getName();
        int equipmentLevel = equipment.getLevel();
        Slot equipmentSlot = equipment.getSlot();

        Armor armor = Plate.Adept.Body(); // Warrior, Body Armor
        String armorName = armor.getName();
        int armorLevel = armor.getLevel();
        Slot armorSlot = armor.getSlot();

        assertTrue(armorName == equipmentName
            && armorLevel == equipmentLevel
            && armorSlot == equipmentSlot
        );
    }

    @Test
    void GetNovice_WarriorBodyAdeptArmor() {
        Role role = Role.Warrior;
        Slot slot = Slot.Body;
        Equipment equipment = Equipment.GetNovice(role, slot);
        String equipmentName = equipment.getName();
        int equipmentLevel = equipment.getLevel();
        Slot equipmentSlot = equipment.getSlot();

        Armor armor = Plate.Novice.Body(); // Warrior, Body Armor
        String armorName = armor.getName();
        int armorLevel = armor.getLevel();
        Slot armorSlot = armor.getSlot();

        assertTrue(armorName == equipmentName
                && armorLevel == equipmentLevel
                && armorSlot == equipmentSlot
        );
    }
}