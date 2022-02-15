package controller.units;

import model.character.Character;

public class NPC extends Character {
    private static NPC instance = null;
    private String introduction = null;

    private NPC() { super(); }

    public static NPC getInstance() {
        if(instance == null) { instance = new NPC(); }
        return instance;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getIntroduction() {
        return this.introduction;
    }
}
