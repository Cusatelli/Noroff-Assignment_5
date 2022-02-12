package model.equipment;

import model.equipment.set.novice.*;

public class NoviceSet extends EquipmentSet {
    public NoviceSet() {
        super(new Armor[]{
                    new NoviceHead(), // Head
                    new NoviceChest(), // Body
                    new NoviceLegs() // Legs
                },
                new NoviceStaff() // Weapon
        );
    }
}
