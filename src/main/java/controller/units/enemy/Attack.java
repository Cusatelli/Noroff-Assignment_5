package controller.units.enemy;

import model.item.equipment.Weapon;

public class Attack extends Weapon {
    public Attack(String name, int level, int damage, double speed, WeaponType type) {
        super(name, level, damage, speed, type);
    }
}
