package model.character;

import model.role.*;
import model.stats.Stats;
import model.item.equipment.Equipped;

/**
 * Abstract Character class used to identify non-hostile units (or Players).
 */
public abstract class Character {
    private String name;
    private Role role;
    private Stats stats;
    private Equipped equipment;

    /**
     * Initialize Character
     */
    public Character() {
        this.name = "Adventurer";
        this.role = Role.Deprived;
        this.stats = Deprived.Stats();
        this.equipment = Deprived.Equipment();
    }

    /**
     * Initialize Character based on Role input.
     * @param role character to create.
     */
    public void initialize(Role role) {
        this.setRole(role);
        switch (role) {
            case Mage -> {
                this.setStats(Mage.Stats());
                this.setEquipment(Mage.Equipment());
            }
            case Rogue -> {
                this.setStats(Rogue.Stats());
                this.setEquipment(Rogue.Equipment());
            }
            case Ranger -> {
                this.setStats(Ranger.Stats());
                this.setEquipment(Ranger.Equipment());
            }
            case Warrior -> {
                this.setStats(Warrior.Stats());
                this.setEquipment(Warrior.Equipment());
            }
        }
    }

    /**
     * Get Character name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set Character name.
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Character take damage.
     * @param damage health to be removed from player.
     */
    public void takeDamage(int damage) {
        this.setHealth(this.getHealth() - damage);
    }

    /**
     * Replenish health of character. Clamped to max health.
     * @param heal heal.
     */
    public void replenishHealth(int heal) {
        if(this.stats.getCurrentHealth() + heal <= this.stats.getMaxHealth()) {
            this.stats.setCurrentHealth(this.stats.getCurrentHealth() + heal);
            return;
        }
        this.stats.setCurrentHealth(this.stats.getMaxHealth());
    }

    /**
     * Get Character current health.
     * @return health.
     */
    public int getHealth() {
        return this.stats.getCurrentHealth();
    }

    /**
     * Set character current health.
     * @param health health.
     */
    public void setHealth(int health) {
        this.stats.setCurrentHealth(health);
    }

    /**
     * Get character role.
     * @return role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Set character role.
     * @param role role.
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Get Character Stats.
     * @return stats.
     */
    public Stats getStats() {
        return stats;
    }

    /**
     * Set character stats.
     * @param stats stats.
     */
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    /**
     * Get Character Equipped Equipment.
     * @return Equipped.
     */
    public Equipped getEquipment() {
        return equipment;
    }

    /**
     * Set Character Equipped Equipment.
     * @param equipment Equipped.
     */
    public void setEquipment(Equipped equipment) {
        this.equipment = equipment;
    }

    /**
     * Get Character Level.
     * @return level.
     */
    public int getLevel() {
        return this.stats.getLevel();
    }

    /**
     * Return true if character health is zero or below.
     * @return false if is not dead.
     */
    public boolean isDead() {
        return this.getHealth() <= 0;
    }

    /**
     * Level up character based on experience.
     * @param experience experience.
     * @return true if leveled up.
     */
    public boolean levelUp(int experience) {
        return this.getStats().levelUp(experience);
    }

    @Override
    public String toString() {
        return "Character {" +
                "\n\tName = '" + name + '\'' +
                "\n\tRole = " + role +
                "\n\tStats = " + stats.prettyPrint() +
                "\n\tEquipment = " + equipment.prettyPrint() +
                "\n}";
    }
}
