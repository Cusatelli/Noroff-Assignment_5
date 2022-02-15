package model.item.equipment.set.mail;

import model.item.equipment.Armor;
import model.item.equipment.set.mail.adept.AdeptChest;
import model.item.equipment.set.mail.adept.AdeptHead;
import model.item.equipment.set.mail.adept.AdeptLegs;
import model.item.equipment.set.mail.novice.NoviceChest;
import model.item.equipment.set.mail.novice.NoviceHead;
import model.item.equipment.set.mail.novice.NoviceLegs;

public class Mail {
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
    }
}