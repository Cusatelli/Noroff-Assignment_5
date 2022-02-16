package controller.units.enemy;

import model.character.Enemy;
import model.item.equipment.Equipment;
import model.item.equipment.Weapon;

/**
 * Goblin extending enemy.
 */
public class Goblin extends Enemy {

    /**
     * Initialize Goblin.
     * @param name Goblin name.
     * @param maxHealth Goblin max health.
     * @param damage Goblin damage.
     * @param experience Goblin experience received on defeat.
     */
    public Goblin(String name, int maxHealth, int damage, int experience) {
        super(name, maxHealth, damage, experience);
        this.setIntroduction(
                "A wild '" + getName() + "' has appeared!" +
                "\nYou prepare yourself before you..."
        );
    }

    @Override
    public Weapon getAttack() {
        return new Attack("Stab", 1, 15, 1.5, Equipment.WeaponType.Knuckles);
    }
}
