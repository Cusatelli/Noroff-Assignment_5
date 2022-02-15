package controller.units.enemy;

import model.character.Enemy;
import model.item.equipment.Equipment;
import model.item.equipment.Weapon;

public class Crow extends Enemy {
    public Crow(String name, int maxHealth, int damage, int experience) {
        super(name, maxHealth, damage, experience);
        this.setIntroduction(
                "You are walking in the forest while looking down at the ground." +
                "\nSuddenly you hear a loud 'Cawing' noise filling the whole area." +
                "\nYou tremble in fear as a frenzied '" + getName() + "' appears before you!" +
                "\nYou prepare yourself before you..."
        );
    }

    @Override
    public Weapon getAttack() {
        return new Attack("Fangs", 1, 10, 1, Equipment.Weapon.Knuckles);
    }
}
