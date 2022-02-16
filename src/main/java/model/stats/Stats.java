package model.stats;

import model.item.equipment.Equipment;

/**
 * Character stats for all Units in the game which holds Level, Exp, Health etc.
 */
public class Stats {
    private int level;
    private int requiredExperience = 5;
    private int currentExperience = 0;
    private int maxHealth;
    private int currentHealth;
    private final Attributes baseAttributes;
    private Attributes totalAttributes;
    private Equipment.ArmorType[] armorTypes;
    private Equipment.WeaponType[] weaponTypes;

    /**
     * Create a new Stats Object containing vital information about a unit.
     * @param level How much experience a unit has earned.
     * @param health How much health the unit has.
     * @param baseAttributes Its starting attributes
     * @param totalAttributes Its total attributes (defaulted to base).
     * @param armorTypes What kind of armor types they can wear (Based on role).
     * @param weaponTypes What kind of weapon types they can equip (Based on role).
     */
    public Stats(int level, int health, Attributes baseAttributes, Attributes totalAttributes, Equipment.ArmorType[] armorTypes, Equipment.WeaponType[] weaponTypes) {
        this.level = level;
        this.maxHealth = health;
        this.currentHealth = health;
        this.baseAttributes = baseAttributes;
        this.totalAttributes = totalAttributes;
        this.armorTypes = armorTypes;
        this.weaponTypes = weaponTypes;
    }

    /**
     * Get the current level of this unit.
     * @return unit level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Set the current level of this unit.
     * Does not account for current level!
     * @param level new unit level.
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Get this units maximum health stat.
     * @return max health.
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * Set this units maximum health stat.
     * @param maxHealth max health.
     */
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    /**
     * Get this units current health stat.
     * @return current health.
     */
    public int getCurrentHealth() {
        return currentHealth;
    }


    /**
     * Set this units current health stat.
     * Does not account for current-currentHealth!
     * @param currentHealth current health.
     */
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    /**
     * Get this units base Attributes.
     * @return base - Attributes.
     */
    public Attributes getBaseAttributes() {
        return baseAttributes;
    }

    /**
     * Get this units total Attributes.
     * Does not account for Equipment stats!
     * @return total - Attributes.
     */
    public Attributes getTotalAttributes() {
        return totalAttributes;
    }

    /**
     * Set required Experience to level up unit.
     * @param requiredExperience how much experience is required to level up.
     */
    public void setRequiredExperience(int requiredExperience) {
        this.requiredExperience = requiredExperience;
    }

    /**
     * Get Required experience to level up this unit.
     * @return how much experience is required to level up.
     */
    public int getRequiredExperience() {
        return this.requiredExperience;
    }

    /**
     * Set current experience this unit has currently accumulated.
     * @param currentExperience current accumulated experience.
     */
    public void setCurrentExperience(int currentExperience) {
        this.currentExperience = currentExperience;
    }

    /**
     * Get currently accumulated experience.
     * @return currently accumulated experience.
     */
    public int getCurrentExperience() {
        return currentExperience;
    }

    /**
     * Level up the character unit by exactly one level if it has enough experience.
     * @param experience how much experience to add.
     * @return true if level up, else false.
     */
    public boolean levelUp(int experience) {
        this.setCurrentExperience(this.currentExperience + experience); // Update current experience
        if(this.getCurrentExperience() >= this.getRequiredExperience()) { // Check if enough to level up
            this.setLevel(this.level + 1); // Increase level.
            this.getTotalAttributes().levelUp(this.getBaseAttributes()); // Update attributes
            int experienceIncrement = 5; // Constant exp modifier
            this.setRequiredExperience(this.requiredExperience + (experienceIncrement * this.level)); // Set new required experience for level up.

            this.setCurrentHealth(this.getMaxHealth()); // Replenish health

            return true; // Return true, because we leveled up.
        }
        return false; // Return false, because we didnt level up.
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
