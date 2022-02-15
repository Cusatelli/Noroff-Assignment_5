package model.character;

import model.item.equipment.Weapon;
import model.item.equipment.weapon.Knuckles;

public abstract class Enemy {
    private String name;
    private String introduction = null;
    private int currentHealth;
    private int maxHealth;
    private int damage;
    private int experience;

    public Enemy(String name, int maxHealth, int damage, int experience) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.damage = damage;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void takeDamage(int damage) {
        this.currentHealth -= damage;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getIntroduction() {
        if(this.introduction == null) {
            this.introduction = "A wild " + getName() + " has appeared!\nPrepare to battle!";
        }
        return this.introduction;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Weapon getAttack() {
        return new Knuckles();
    }

    public boolean isDead() {
        return this.getCurrentHealth() <= 0;
    }
}

