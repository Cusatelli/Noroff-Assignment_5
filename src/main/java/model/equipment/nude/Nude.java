package model.equipment.nude;

import model.equipment.Armor;
import model.equipment.mail.novice.NoviceChest;
import model.equipment.mail.novice.NoviceHead;
import model.equipment.mail.novice.NoviceLegs;

public class Nude {
    public static class Deprived {
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
