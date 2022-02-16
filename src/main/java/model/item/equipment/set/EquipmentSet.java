package model.item.equipment.set;

import model.item.equipment.Armor;
import model.item.equipment.Equipment;
import model.item.equipment.Slot;
import model.item.equipment.Weapon;

import java.util.HashMap;
import java.util.Map;

/**
 * Equipment set to ease creation of armor and weapon sets matching ones of roles.
 */
public abstract class EquipmentSet {
    private Map<Slot, Equipment> equipment = new HashMap<Slot, Equipment>();

    /**
     * Initialize Equipment Set.
     * @param armors array of armors
     * @param weapon weapon
     */
    public EquipmentSet(Armor[] armors, Weapon weapon) {
        for (Armor armor : armors) {
            this.equipment.put(armor.getSlot(), armor);
        }
        this.equipment.put(Slot.Weapon, weapon);
    }

    /**
     * Get equipment slot.
     * @param slot slot.
     * @return Equipment from that slot.
     */
    public Equipment get(Slot slot) {
        return equipment.get(slot);
    }

    public void setEquipment(Map<Slot, Equipment> equipment) {
        this.equipment = equipment;
    }
}
