package model.item.equipment.set.nude;

import exception.InvalidArmorException;
import model.item.equipment.Armor;
import model.item.equipment.Slot;
import model.item.equipment.set.cloth.novice.NoviceChest;
import model.item.equipment.set.cloth.novice.NoviceHead;
import model.item.equipment.set.cloth.novice.NoviceLegs;

/**
 * Collection of Nude armor items.
 */
public class Nude {

    /**
     * Deprived Role items.
     */
    public static class Deprived {

        /**
         * Set Deprived armor.
         * @return Armor array.
         */
        public static Armor[] Set() {
            return new Armor[] {
                new NoviceHead(),// Head
                new NoviceChest(), // Body
                new NoviceLegs() // Legs
            };
        }

        /**
         * Initialize Head armor.
         * @return Armor with Head slot.
         */
        public static Armor Head() {
            return new NoviceHead();
        }

        /**
         * Initialize Body armor.
         * @return Armor with Body slot.
         */
        public static Armor Body() {
            return new NoviceChest();
        }

        /**
         * Initialize Legs armor.
         * @return Armor with Legs slot.
         */
        public static Armor Legs() {
            return new NoviceLegs();
        }

        /**
         * Get Armor from a specific slot.
         * @param slot armor slot.
         * @return Armor.
         */
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
