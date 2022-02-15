package controller.units.enemy;

import model.character.Enemy;
import model.item.equipment.Equipment;
import model.item.equipment.Weapon;

public class Mercenary extends Enemy {
    public Mercenary(String name, int maxHealth, int damage, int experience) {
        super(name, maxHealth, damage, experience);
        this.setIntroduction(
                "Hoho! What a night! I can't believe it's already over!" +
                "\nOh.. uh oh! *BAM*" +
                "\n..." +
                "\n... ... !!!!" +
                "\nHEY YOU! GET YOUR DRUNK BUTT OVER HERE AND FIGHT ME!" +
                "\nThe '" + getName() + "' approaches you with a fury in his eye." +
                "\nYou prepare yourself before you..."
        );
    }

    @Override
    public Weapon getAttack() {
        return new Attack("Punch", 1, 15, 0.5, Equipment.WeaponType.Knuckles);
    }
}
