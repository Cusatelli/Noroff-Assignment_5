package model.equipment.mail;

import model.equipment.Armor;
import model.equipment.mail.novice.NoviceChest;
import model.equipment.mail.novice.NoviceHead;
import model.equipment.mail.novice.NoviceLegs;

public class Mail {
    public static class Novice {
        public static Armor[] Set() { return new Armor[] {
                new NoviceHead(),// Head
                new NoviceChest(), // Body
                new NoviceLegs() // Legs
            };
        }
    }
}
