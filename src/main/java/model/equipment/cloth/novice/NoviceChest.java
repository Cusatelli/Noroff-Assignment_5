package model.equipment.cloth.novice;

import model.equipment.Armor;
import model.equipment.Equipment;
import model.equipment.Slot;

public class NoviceChest extends Armor {
    public NoviceChest() {
        super("Novice Robe", 1, 0, Slot.Body, Equipment.Armor.Cloth);
    }
}
