package controller.enemy;

import model.character.Enemy;

public class Boar extends Enemy {
    private static Boar instance = null;

    public Boar(String name, int maxHealth, int damage) {
        super(name, maxHealth, damage);
    }

    public static Boar getInstance() {
        if(instance == null) { instance = new Boar("Boar", 50, 5); }
        return instance;
    }

    public Boar spawn(int health, int damage) {
        instance = new Boar("Boar", health, damage);
        return instance;
    }
}
