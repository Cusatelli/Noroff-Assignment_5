package model.equipment.leather;

import model.equipment.Armor;
import model.equipment.leather.novice.NoviceChest;
import model.equipment.leather.novice.NoviceHead;
import model.equipment.leather.novice.NoviceLegs;

public class Leather {
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
