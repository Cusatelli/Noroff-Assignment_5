package model.role;

import model.equipment.Equipped;
import model.equipment.NoviceSet;
import model.stats.Attributes;
import model.stats.Stats;

public class Ranger extends Stats {
    public Ranger() {
        super(
            1,
            100,
            new Attributes(1, 7, 1, 0),
            new Attributes(1, 7, 1, 0) // Initialize to same as base.
        );
    }

    public static Equipped Equipment() {
        return new Equipped(new NoviceSet());
    }
}
