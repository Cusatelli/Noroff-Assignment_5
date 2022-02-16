package model.stats;

public class Attributes {
    private int strength;
    private int dexterity;
    private int intelligence;
    private int resilience;

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

    public void levelUp(Attributes increment) {
        this.setStrength(this.strength + increment.getStrength());
        this.setDexterity(this.dexterity + increment.getDexterity());
        this.setIntelligence(this.intelligence + increment.getIntelligence());
        this.setResilience(this.resilience + increment.getResilience());
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

    public String toStringStats() {
        StringBuilder stringBuilder = new StringBuilder("{");
        if(strength != 0) { stringBuilder.append("\n\t\t\tStrength = " + strength); }
        if(dexterity != 0) { stringBuilder.append("\n\t\t\tDexterity = " + dexterity); }
        if(intelligence != 0) { stringBuilder.append("\n\t\t\tIntelligence = " + intelligence); }
        if(resilience != 0) { stringBuilder.append("\n\t\t\tResilience = " + resilience); }
        stringBuilder.append("\n\t\t}");
        return stringBuilder.toString();
    }

    public String toStringEquipment() {
        StringBuilder stringBuilder = new StringBuilder("{");
        if(strength != 0) { stringBuilder.append("\n\t\t\t\tStrength = " + strength); }
        if(dexterity != 0) { stringBuilder.append("\n\t\t\t\tDexterity = " + dexterity); }
        if(intelligence != 0) { stringBuilder.append("\n\t\t\t\tIntelligence = " + intelligence); }
        if(resilience != 0) { stringBuilder.append("\n\t\t\t\tResilience = " + resilience); }
        stringBuilder.append("\n\t\t\t}");
        return stringBuilder.toString();
    }
}
