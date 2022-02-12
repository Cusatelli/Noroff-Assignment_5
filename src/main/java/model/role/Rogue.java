package model.role;

import model.equipment.Equipped;
import model.equipment.NoviceSet;
import model.stats.Attributes;
import model.stats.Stats;

public class Rogue extends Stats {
    public Rogue() {
        super(
            1,
            100,
            new Attributes(2, 6, 1, 0),
            new Attributes(2, 6, 1, 0) // Initialize to same as base.
        );
    }

    public static Equipped Equipment() {
        return new Equipped(new NoviceSet());
    }
}
