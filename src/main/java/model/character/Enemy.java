package model.character;

import model.item.equipment.Weapon;
import model.item.equipment.weapon.Knuckles;

/**
 * Abstract Enemy class.
 */
public abstract class Enemy {
    private String name;
    private String introduction = null;
    private int currentHealth;
    private int maxHealth;
    private int damage;
    private int experience;

    /**
     * Initialize Enemy class.
     * @param name enemy name.
     * @param maxHealth enemy max health.
     * @param damage enemy damage.
     * @param experience enemy experience amount reward on defeat.
     */
    public Enemy(String name, int maxHealth, int damage, int experience) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.damage = damage;
        this.experience = experience;
    }

    /**
     * Get Enemy name.
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set Enemy name.
     * @param name name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get Enemy Current Health.
     * @return current health.
     */
    public int getCurrentHealth() {
        return currentHealth;
    }

    /**
     * Set Enemy Current Health.
     * @param currentHealth current health.
     */
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    /**
     * Get Enemy Maximum Health.
     * @return maximum health.
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * Set Enemy Maximum Health.
     * @param maxHealth maximum health.
     */
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    /**
     * Get Enemy Damage.
     * @return damage.
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Set Enemy Damage.
     * @param damage damage.
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * Enemy Take Damage from source.
     * @param damage damage to take.
     */
    public void takeDamage(int damage) {
        this.currentHealth -= damage;
    }

    /**
     * Set introduction to be displayed when enemy appears before user.
     * @param introduction introduction
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /**
     * Get introduction to be displayed when enemy appears before user.
     * @return introduction
     */
    public String getIntroduction() {
        if(this.introduction == null) { // If none default.
            this.introduction = "A wild " + getName() + " has appeared!\nPrepare to battle!";
        }
        return this.introduction;
    }

    /**
     * Get Enemy Experience Reward on defeat.
     * @return experience.
     */
    public int getExperience() {
        return experience;
    }

    /**
     * Set Enemy Experience Reward on defeat.
     * @param experience experience.
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }

    /**
     * Get Default Attack Weapon.
     * @return Knuckles Weapon.
     */
    public Weapon getAttack() {
        return new Knuckles();
    }

    /**
     * Check if health is less or zero.
     * @return if less or zero, return true.
     */
    public boolean isDead() {
        return this.getCurrentHealth() <= 0;
    }
}
