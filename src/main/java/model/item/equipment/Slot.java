package model.item.equipment;

/**
 * Enum of Equipment Slots.
 */
public enum Slot {
    Head,
    Body,
    Legs,
    Weapon;

    /**
     * Get the appropriate slot based on index.
     * @param index index to find slot.
     * @return slot.
     */
    public static Slot get(int index) { // TODO: Simplify.
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
