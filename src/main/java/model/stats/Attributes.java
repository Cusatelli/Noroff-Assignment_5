package model.stats;

public class Attributes {
    private int strength = 0;
    private int dexterity = 0;
    private int intelligence = 0;
    private int resilience = 0;

    public Attributes(int strength, int dexterity, int intelligence, int resilience) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.resilience = resilience;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getResilience() {
        return resilience;
    }

    public void setResilience(int resilience) {
        this.resilience = resilience;
    }

    @Override
    public String toString() {
        return "Attributes { " +
                "Strength = " + strength +
                ", Dexterity = " + dexterity +
                ", Intelligence = " + intelligence +
                ", Resilience = " + resilience +
                " }";
    }

    public String prettyPrint() {
        return "{" +
                "\n\t\t\tStrength = " + strength +
                "\n\t\t\tDexterity = " + dexterity +
                "\n\t\t\tIntelligence = " + intelligence +
                "\n\t\t\tResilience = " + resilience +
                "\n\t\t}";
    }
}
