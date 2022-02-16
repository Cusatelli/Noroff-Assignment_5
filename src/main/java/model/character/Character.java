package model.character;

import model.role.*;
import model.stats.Stats;
import model.item.equipment.Equipped;

public abstract class Character {
    private String name;
    private Role role;
    private Stats stats;
    private Equipped equipment;

    public Character() {
        this.name = "Adventurer";
        this.role = Role.Deprived;
        this.stats = Deprived.Stats();
        this.equipment = Deprived.Equipment();
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void takeDamage(int damage) {
        this.setHealth(this.getHealth() - damage);
    }

    public void replenishHealth(int heal) {
        this.setHealth(this.getHealth() + heal);
    }

    public int getHealth() {
        return this.stats.getCurrentHealth();
    }

    public void setHealth(int health) {
        this.stats.setCurrentHealth(health);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Equipped getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipped equipment) {
        this.equipment = equipment;
    }

    public int getLevel() {
        return this.stats.getLevel();
    }

    public boolean isDead() {
        return this.getHealth() <= 0;
    }

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
