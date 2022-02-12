package model.character;

import model.role.Mage;
import model.role.Ranger;
import model.role.Rogue;
import model.role.Warrior;
import model.stats.Stats;
import model.equipment.Equipped;

public abstract class Character {
    private String name;
    private Role role;
    private Stats stats;
    private Equipped equipment;

    public Character(String name, Role role, Stats stats, Equipped equipment) {
        this.name = name;
        this.role = role;
        this.stats = stats;
        this.equipment = equipment;
    }

    public Character() {
        this.name = "Adventurer";
        this.role = Role.Deprived;
        this.stats = new Stats(1, 15, null, null);
        this.equipment = null;
    }

    public void initialize(Role role) {
        this.setRole(role);
        switch (role) {
            case Mage -> {
                this.setStats(Mage.Stats());
                this.setEquipment(Mage.Equipment());
            }
            case Rogue -> {
                this.setStats(new Rogue());
            }
            case Ranger -> {
                this.setStats(new Ranger());
            }
            case Warrior -> {
                this.setStats(new Warrior());
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
