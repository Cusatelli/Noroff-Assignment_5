package model.item.equipment.set.nude;

import model.item.equipment.Armor;
import model.item.equipment.set.cloth.novice.NoviceChest;
import model.item.equipment.set.cloth.novice.NoviceHead;
import model.item.equipment.set.cloth.novice.NoviceLegs;

public class Nude {
    public static class Deprived {
        public static Armor[] Set() {
            return new Armor[] {
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
