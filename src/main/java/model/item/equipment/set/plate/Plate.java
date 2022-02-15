package model.item.equipment.set.plate;

import exception.InvalidArmorException;
import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.item.equipment.set.plate.adept.AdeptChest;
import model.item.equipment.set.plate.adept.AdeptHead;
import model.item.equipment.set.plate.adept.AdeptLegs;
import model.item.equipment.set.plate.novice.NoviceChest;
import model.item.equipment.set.plate.novice.NoviceHead;
import model.item.equipment.set.plate.novice.NoviceLegs;

public class Plate {
    public static class Novice {
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

        public static Armor Get(Slot slot) {
            switch (slot) {
                case Head -> { return Head(); }
                case Body -> { return Body(); }
                case Legs -> { return Legs(); }
            }
            try { throw new InvalidArmorException("Can not get slot: " + slot); }
            catch (InvalidArmorException e) { e.printStackTrace(); }
            return null;
        }
    }

    public static class Adept {
        public static Armor[] Set() {
            return new Armor[] {
                    new AdeptHead(),// Head
                    new AdeptChest(), // Body
                    new AdeptLegs() // Legs
            };
        }

        public static Armor Head() {
            return new AdeptHead();
        }
        public static Armor Body() {
            return new AdeptChest();
        }
        public static Armor Legs() {
            return new AdeptLegs();
        }

        public static Armor Get(Slot slot) {
            switch (slot) {
                case Head -> { return Head(); }
                case Body -> { return Body(); }
                case Legs -> { return Legs(); }
            }
            try { throw new InvalidArmorException("Can not get slot: " + slot); }
            catch (InvalidArmorException e) { e.printStackTrace(); }
            return null;
        }
    }
}
