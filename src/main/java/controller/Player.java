package controller;

import model.character.Character;
import model.equipment.Equipped;
import model.character.Role;
import model.equipment.Weapon;
import model.stats.Attributes;
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

    public double getDamage() {
        Weapon weapon =  this.getEquipment().getWeapon();
        double weaponDamage = (weapon.getDamage() * weapon.getSpeed());
        double statModifier = 0;
        Attributes playerAttributes = getStats().getTotalAttributes();
        switch (getRole()) {
            case Deprived -> statModifier = (playerAttributes.getStrength() + playerAttributes.getDexterity()) / 1.5;
            case Mage -> statModifier = playerAttributes.getIntelligence();
            case Rogue, Ranger -> statModifier = playerAttributes.getDexterity();
            case Warrior -> statModifier = playerAttributes.getStrength();
        }

        return weaponDamage + (weaponDamage * (statModifier / 100));
    }

    public Player(String name, Role role, Stats stats, Equipped equipment) {
        super(name, role, stats, equipment);
    }
}
