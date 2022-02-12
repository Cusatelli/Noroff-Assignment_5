package model.stats;

public class Stats {
    private int level = 0;
    private int health = 0;
    private Attributes baseAttributes;
    private Attributes totalAttributes;

    public Stats(int level, int health, Attributes baseAttributes, Attributes totalAttributes) {
        this.level = level;
        this.health = health;
        this.baseAttributes = baseAttributes;
        this.totalAttributes = totalAttributes;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Attributes getBaseAttributes() {
        return baseAttributes;
    }

    public void setBaseAttributes(Attributes baseAttributes) {
        this.baseAttributes = baseAttributes;
    }

    public Attributes getTotalAttributes() {
        return totalAttributes;
    }

    public void setTotalAttributes(Attributes totalAttributes) {
        this.totalAttributes = totalAttributes;
    }

    @Override
    public String toString() {
        return "Stats { " +
                "Level = " + level +
                ", Health = " + health +
                ", BaseAttributes = " + baseAttributes +
                ", TotalAttributes = " + totalAttributes +
                " }";
    }

    public String prettyPrint() {
        return "{" +
                "\n\t\tLevel = " + level +
                "\n\t\tHealth = " + health +
                "\n\t\tBaseAttributes = " + baseAttributes.prettyPrint() +
                "\n\t\tTotalAttributes = " + totalAttributes.prettyPrint() +
                "\n\t}";
    }
}
