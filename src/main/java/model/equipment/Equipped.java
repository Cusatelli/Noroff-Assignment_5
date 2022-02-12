package model.equipment;

public class Equipped {
    private Armor head;
    private Armor body;
    private Armor legs;
    private Weapon weapon;

    public Equipped(Armor head, Armor body, Armor legs, Weapon weapon) {
        this.head = head;
        this.body = body;
        this.legs = legs;
        this.weapon = weapon;
    }

    public Equipped(EquipmentSet equipmentSet) {
        this.head = (Armor)equipmentSet.get(Slot.Head);
        this.body = (Armor)equipmentSet.get(Slot.Body);
        this.legs = (Armor)equipmentSet.get(Slot.Legs);
        this.weapon = (Weapon)equipmentSet.get(Slot.Weapon);
    }

    public Armor getHead() {
        return head;
    }

    public void setHead(Armor head) {
        this.head = head;
    }

    public Armor getBody() {
        return body;
    }

    public void setBody(Armor body) {
        this.body = body;
    }

    public Armor getLegs() {
        return legs;
    }

    public void setLegs(Armor legs) {
        this.legs = legs;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
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
