package model.item.equipment;

public enum Slot {
    Head,
    Body,
    Legs,
    Weapon;

    public static Slot get(int index) {
        switch (index) {
            case 0 -> {
                return Head;
            }
            case 1 -> {
                return Body;
            }
            case 2 -> {
                return Legs;
            }
            default -> { // & 3
                return Weapon;
            }
        }
    }
}
