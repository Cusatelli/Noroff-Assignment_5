package controller;

import model.character.Character;
import model.equipment.Equipped;
import model.character.Role;
import model.stats.Stats;

public class Player extends Character {
    private static Player instance = null;

    public Player() {
        super();
    }

    public static Player getInstance() {
        if(instance == null) { instance = new Player(); }
        return instance;
    }

    public Player(String name, Role role, Stats stats, Equipped equipment) {
        super(name, role, stats, equipment);
    }
}
