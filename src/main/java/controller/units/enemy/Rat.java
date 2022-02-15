package controller.units.enemy;

import model.character.Enemy;
import model.item.equipment.Equipment;
import model.item.equipment.Weapon;

public class Rat extends Enemy {
    public Rat(String name, int maxHealth, int damage, int experience) {
        super(name, maxHealth, damage, experience);
        this.setIntroduction(
                "A wild '" + getName() + "' has appeared!" +
                "\nYou prepare yourself before you..."
        );
    }

    @Override
    public Weapon getAttack() {
        return new Attack("Gnaw", 1, 1, 4, Equipment.Weapon.Knuckles);
    }
}
