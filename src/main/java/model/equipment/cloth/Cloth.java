package model.equipment.cloth;

import model.equipment.Armor;
import model.equipment.cloth.novice.NoviceChest;
import model.equipment.cloth.novice.NoviceHead;
import model.equipment.cloth.novice.NoviceLegs;

public class Cloth {
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
