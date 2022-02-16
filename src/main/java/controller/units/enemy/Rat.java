package controller.units.enemy;

import model.character.Enemy;
import model.item.equipment.Equipment;
import model.item.equipment.Weapon;

/**
 * Rat extending enemy.
 */
public class Rat extends Enemy {

    /**
     * Initialize Rat.
     * @param name rat name.
     * @param maxHealth rat max health.
     * @param damage rat damage.
     * @param experience rat experience received on defeat.
     */
    public Rat(String name, int maxHealth, int damage, int experience) {
        super(name, maxHealth, damage, experience);
        this.setIntroduction(
                "A wild '" + getName() + "' has appeared!" +
                "\nYou prepare yourself before you..."
        );
    }

    @Override
    public Weapon getAttack() {
        return new Attack("Gnaw", 1, 1, 4, Equipment.WeaponType.Knuckles);
    }
}
