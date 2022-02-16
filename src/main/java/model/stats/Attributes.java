package model.stats;

/**
 * Attributes for Armor and Stats (Character Units).
 * Consists of Strength, Dexterity, Intelligence & Resilience.
 */
public class Attributes {
    private int strength;
    private int dexterity;
    private int intelligence;
    private int resilience;

    /**
     * Initialize Attributes with input attributes.
     * @param strength Unit Strength
     * @param dexterity Unit Dexterity
     * @param intelligence Unit Intelligence
     * @param resilience Unit Resilience
     */
    public Attributes(int strength, int dexterity, int intelligence, int resilience) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.resilience = resilience;
    }

    /**
     * Get Strength Attribute.
     * @return Unit Strength.
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Set Strength Attribute.
     * @param strength Unit Strength.
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * Get Dexterity Attribute.
     * @return Unit Dexterity.
     */
    public int getDexterity() {
        return dexterity;
    }

    /**
     * Set Dexterity Attribute.
     * @param dexterity Unit Dexterity.
     */
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    /**
     * Get Intelligence Attribute.
     * @return Unit Intelligence.
     */
    public int getIntelligence() {
        return intelligence;
    }

    /**
     * Set Intelligence Attribute.
     * @param intelligence Unit Intelligence.
     */
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    /**
     * Get Resilience Attribute.
     * @return Unit Resilience.
     */
    public int getResilience() {
        return resilience;
    }

    /**
     * Set Resilience Attribute.
     * @param resilience Unit Resilience.
     */
    public void setResilience(int resilience) {
        this.resilience = resilience;
    }

    /**
     * Level Up all available Unit Attributes.
     * @param increment new Attribute Class values.
     */
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
