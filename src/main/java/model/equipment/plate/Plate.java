package model.equipment.plate;

import model.equipment.Armor;
import model.equipment.plate.novice.NoviceChest;
import model.equipment.plate.novice.NoviceHead;
import model.equipment.plate.novice.NoviceLegs;

public class Plate {
    public static class Novice {
        public static Armor[] Set() { return new Armor[] {
                new NoviceHead(),// Head
                new NoviceChest(), // Body
                new NoviceLegs() // Legs
            };
        }

        public static Armor Head() {
            return new NoviceHead();
        }
        public static Armor Body() {
            return new NoviceChest();
        }
        public static Armor Legs() {
            return new NoviceLegs();
        }
    }
}
