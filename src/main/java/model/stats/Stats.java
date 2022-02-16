package model.stats;

import model.item.equipment.Equipment;

public class Stats {
    private int level = 0;
    private int requiredExperience = 5;
    private int currentExperience = 0;
    private int maxHealth = 0;
    private int currentHealth = 0;
    private final Attributes baseAttributes;
    private Attributes totalAttributes;
    private Equipment.ArmorType[] armorTypes;
    private Equipment.WeaponType[] weaponTypes;

    public Stats(int level, int health, Attributes baseAttributes, Attributes totalAttributes, Equipment.ArmorType[] armorTypes, Equipment.WeaponType[] weaponTypes) {
        this.level = level;
        this.maxHealth = health;
        this.currentHealth = health;
        this.baseAttributes = baseAttributes;
        this.totalAttributes = totalAttributes;
        this.armorTypes = armorTypes;
        this.weaponTypes = weaponTypes;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public Attributes getBaseAttributes() {
        return baseAttributes;
    }

    public Attributes getTotalAttributes() {
        return totalAttributes;
    }

    public void setRequiredExperience(int requiredExperience) {
        this.requiredExperience = requiredExperience;
    }

    public int getRequiredExperience() {
        return this.requiredExperience;
    }

    public void setCurrentExperience(int currentExperience) {
        this.currentExperience = currentExperience;
    }

    public int getCurrentExperience() {
        return currentExperience;
    }

    public boolean levelUp(int experience) {
        this.setCurrentExperience(this.currentExperience + experience);
        if(this.getCurrentExperience() >= this.getRequiredExperience()) {
            this.setLevel(this.level + 1);
            this.getTotalAttributes().levelUp(this.getBaseAttributes());
            int experienceIncrement = 5;
            this.setRequiredExperience(this.requiredExperience + (experienceIncrement * this.level));

            this.setCurrentHealth(this.getMaxHealth()); // Replenish health

            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Stats { " +
                "Level = " + level +
                ", Health = " + maxHealth +
                ", BaseAttributes = " + baseAttributes +
                ", TotalAttributes = " + totalAttributes +
                " }";
    }

    public String prettyPrint() {
        return "{" +
                "\n\t\tLevel = " + level +
                "\n\t\tHealth = " + maxHealth +
                "\n\t\tAttributes = " + totalAttributes.toStringStats() +
                "\n\t}";
    }
}
