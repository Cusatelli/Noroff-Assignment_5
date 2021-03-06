package controller.units.enemy;

import model.character.Enemy;
import model.item.equipment.Equipment;
import model.item.equipment.Weapon;

/**
 * Drowner extending enemy.
 */
public class Drowner extends Enemy {

    /**
     * Initialize Drowner.
     * @param name Drowner name.
     * @param maxHealth Drowner max health.
     * @param damage Drowner damage.
     * @param experience Drowner experience received on defeat.
     */
    public Drowner(String name, int maxHealth, int damage, int experience) {
        super(name, maxHealth, damage, experience);
        this.setIntroduction(
                "It's getting dark at the lake... You're thinking about heading home when you spot it emerging from the lake..." +
                "\nOugh, the smell! It's awful!" +
                "\nDamn! It's a '" + getName() + "'! Just my luck..." +
                "\nYou prepare yourself before you..."
        );
    }

    @Override
    public Weapon getAttack() {
        return new Attack("Bite", 1, 11, 0.9, Equipment.WeaponType.Knuckles);
    }
}
