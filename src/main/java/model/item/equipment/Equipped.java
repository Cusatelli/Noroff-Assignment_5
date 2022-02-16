package model.item.equipment;

import model.item.Item;
import model.item.equipment.set.EquipmentSet;

/**
 * Equipped items on character unit.
 */
public class Equipped {
    private Armor head;
    private Armor body;
    private Armor legs;
    private Weapon weapon;

    /**
     * Initialize Equipped items.
     * @param head head armor.
     * @param body body armor.
     * @param legs legs armor.
     * @param weapon weapon.
     */
    public Equipped(Armor head, Armor body, Armor legs, Weapon weapon) {
        this.head = head;
        this.body = body;
        this.legs = legs;
        this.weapon = weapon;
    }

    /**
     * Initialize Equipped items.
     * @param equipmentSet a complete set of armor[] and weapon.
     */
    public Equipped(EquipmentSet equipmentSet) {
        this.head = (Armor)equipmentSet.get(Slot.Head);
        this.body = (Armor)equipmentSet.get(Slot.Body);
        this.legs = (Armor)equipmentSet.get(Slot.Legs);
        this.weapon = (Weapon)equipmentSet.get(Slot.Weapon);
    }

    /**
     * Initialize Equipped items.
     * @param armors a complete set of armor[].
     * @param weapon a weapon.
     */
    public Equipped(Armor[] armors, Weapon weapon) {
        this.head = armors[0];
        this.body = armors[1];
        this.legs = armors[2];
        this.weapon = weapon;
    }

    /**
     * Get Armor head.
     * @return head armor.
     */
    public Armor getHead() {
        return head;
    }

    /**
     * Set Armor head.
     * @param head head armor.
     */
    public void setHead(Armor head) {
        this.head = head;
    }

    /**
     * Get Armor body.
     * @return body armor.
     */
    public Armor getBody() {
        return body;
    }

    /**
     * Set Armor body.
     * @param body body armor.
     */
    public void setBody(Armor body) {
        this.body = body;
    }

    /**
     * Get Armor legs.
     * @return legs armor.
     */
    public Armor getLegs() {
        return legs;
    }

    /**
     * Set Armor legs.
     * @param legs legs armor.
     */
    public void setLegs(Armor legs) {
        this.legs = legs;
    }

    /**
     * Get Weapon.
     * @return weapon.
     */
    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * Set Weapon
     * @param weapon weapon.
     */
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * Determine which armor item the slot is and equip it.
     * @param item random item.
     */
    public void set(Item item) {
        switch (item.getSlot()) {
            case Head -> setHead((Armor) item);
            case Body -> setBody((Armor) item);
            case Legs -> setLegs((Armor) item);
            case Weapon -> setWeapon((Weapon) item);
        }
    }

    @Override
    public String toString() {
        return "Equipped { " +
                "Head = " + head +
                ", Body = " + body +
                ", Legs = " + legs +
                ", Weapon = " + weapon +
                " }";
    }

    public String prettyPrint() {
        return "{ " +
                "\n\t\tHead = " + head.prettyPrint() +
                "\n\t\tBody = " + body.prettyPrint() +
                "\n\t\tLegs = " + legs.prettyPrint() +
                "\n\t\tWeapon = " + weapon.prettyPrint() +
                "\n\t}";
    }
}
