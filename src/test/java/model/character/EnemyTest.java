package model.character;

import controller.units.enemy.*;
import model.item.equipment.Equipment;
import model.item.equipment.Weapon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {

    @Test
    void Name_SetNameToDrowner_GetNameDrowner() {
        String name = "Drowner";
        Enemy enemy = new Drowner("Enemy", 10, 10, 5);
        enemy.setName(name);
        String enemyName = enemy.getName();

        assertEquals(name, enemyName);
    }

    @Test
    void CurrentHealth_SetFifty_GetFifty() {
        int current = 50;
        Enemy enemy = new Drowner("Drowner", 10, 5, 1);
        enemy.setCurrentHealth(current);
        int enemyCurrent = enemy.getCurrentHealth();

        assertEquals(current, enemyCurrent);
    }

    @Test
    void MaxHealth_SetFifty_GetFifty() {
        int max = 50;
        Enemy enemy = new Drowner("Bloated Drowner", 10, 5, 1);
        enemy.setMaxHealth(max);
        int enemyMax = enemy.getMaxHealth();

        assertEquals(max, enemyMax);
    }

    @Test
    void Damage_SetTen_GetTen() {
        int damage = 10;
        Enemy enemy = new Crow("Cakaw", 15, 1, 1);
        enemy.setDamage(damage);
        int enemyDamage = enemy.getDamage();

        assertEquals(damage, enemyDamage);
    }

    @Test
    void SetIntroduction_IfNoIntroductionSpecifiedGoToDefault() {
        String name = "Frenzied Crow";
        String intro = name + " has appeared!";
        Enemy enemy = new Crow(name, 30, 10, 5);
        enemy.setIntroduction(intro);
        String enemyIntroduction = enemy.getIntroduction();

        assertEquals(intro, enemyIntroduction);
    }

    @Test
    void GetExperience_OnEnemyCreateSetExperienceWorth_ExpectTwentyFive() {
        int exp = 25;
        Enemy enemy = new Goblin("Crazy Goblin", 30, 10, exp);
        int enemyExp = enemy.getExperience();

        assertEquals(exp, enemyExp);
    }

    @Test
    void GetAttack_DefaultRatAttack_GnawTypeWeapon() {
        Enemy enemy = new Rat("Sewer Rat", 1, 1, 1);
        Attack attack = new Attack("Gnaw", 1, 1, 4, Equipment.WeaponType.Knuckles);
        String attackName = attack.getName();
        int attackLevel = attack.getLevel();
        int attackDamage = attack.getDamage();
        double attackSpeed = attack.getSpeed();
        Equipment.WeaponType attackType = attack.getWeaponType();

        Weapon enemyAttack = enemy.getAttack();
        String enemyWeaponName = enemyAttack.getName();
        int enemyWeaponLevel = enemyAttack.getLevel();
        int enemyWeaponDamage = enemyAttack.getDamage();
        double enemyWeaponSpeed = enemyAttack.getSpeed();
        Equipment.WeaponType enemyWeaponType = enemyAttack.getWeaponType();

        assertTrue(attackName == enemyWeaponName
            && attackLevel == enemyWeaponLevel
            && attackDamage == enemyWeaponDamage
            && attackSpeed == enemyWeaponSpeed
            && attackType == enemyWeaponType
        );
    }

    @Test
    void IsDead_OnLessThanZeroHealthDie_ExpectedTrue() {
        Enemy enemy = new Mercenary("Drunken Mercenary", 15, 2, 3);
        enemy.takeDamage(17);
        boolean enemyIsDead = enemy.isDead();

        assertTrue(enemyIsDead);
    }

    @Test
    void IsDead_OnMoreThanZeroHealthDie_ExpectedFalse() {
        Enemy enemy = new Mercenary("Drunken Mercenary", 15, 2, 3);
        enemy.takeDamage(2);
        boolean enemyIsDead = enemy.isDead();

        assertFalse(enemyIsDead);
    }

    @Test
    void Experience() {
        int exp = 15;
        Enemy enemy = new Crow("Name", 1, 1, 1);
        enemy.setExperience(exp);

        assertEquals(exp, enemy.getExperience());
    }
}