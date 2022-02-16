package controller.units;

import model.character.Character;

/**
 * NPC extending Character
 */
public class NPC extends Character {
    private static NPC instance = null;
    private String introduction = null;

    private NPC() { super(); }

    /**
     * Singleton.
     * @return NPC
     */
    public static NPC getInstance() {
        if(instance == null) { instance = new NPC(); }
        return instance;
    }

    /**
     * Set NPC introduction
     * @param introduction NPC intro.
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /**
     * Get NPC introduction
     * @return NPC intro.
     */
    public String getIntroduction() {
        return this.introduction;
    }
}
