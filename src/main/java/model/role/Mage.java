package model.role;

import model.equipment.Equipped;
import model.equipment.NoviceSet;
import model.stats.Attributes;
import model.stats.Stats;

public class Mage {
    public static Stats Stats() {
        return new Stats(
                1,
                100,
                new Attributes(1, 1, 8, 0),
                new Attributes(1, 1, 8, 0) // Initialize to same as base.
        );
    }

    public static Equipped Equipment() {
        return new Equipped(new NoviceSet());
    }
}
