package model.item;

import model.character.Role;
import model.item.equipment.Armor;
import model.item.equipment.Equipment;
import model.item.equipment.Slot;
import model.item.equipment.Weapon;
import model.item.equipment.set.cloth.Cloth;
import model.item.equipment.set.leather.Leather;
import model.item.equipment.set.mail.Mail;
import model.item.equipment.set.nude.Nude;
import model.item.equipment.set.plate.Plate;
import model.item.equipment.weapon.Knuckles;
import model.item.equipment.weapon.MasterKnuckles;
import model.item.equipment.weapon.axe.AdeptAxe;
import model.item.equipment.weapon.axe.NoviceAxe;
import model.item.equipment.weapon.bow.AdeptBow;
import model.item.equipment.weapon.bow.NoviceBow;
import model.item.equipment.weapon.dagger.AdeptDagger;
import model.item.equipment.weapon.dagger.NoviceDagger;
import model.item.equipment.weapon.staff.AdeptStaff;
import model.item.equipment.weapon.staff.NoviceStaff;

/**
 * Item class used when shopping items from NPCs and generalizing Equipment.
 */
public class Item {
    private String name;
    private int level;
    private int value;
    private ItemType type;
    private Role role;
    private Slot slot;

    /**
     * Item Types available in-game.
     */
    public enum ItemType {
        Healing,
        Equipment
    }

    /**
     * Initialize Item Class with base information.
     * @param name Item Name
     * @param level Item Level (Usually 'required level'),
     * @param value Item value, symbolises strength of potions and other consumables.
     * @param type Item Type is describing which kind of item this is.
     */
    public Item(String name, int level, int value, ItemType type) {
        this.name = name;
        this.level = level;
        this.value = value;
        this.type = type;
        this.role = null; // Default null if is Consumable (Healing).
    }


    /**
     * Initialize Item Class with base information.
     * @param name Item Name
     * @param level Item Level (Usually 'required level'),
     * @param value Item value, symbolises strength of potions and other consumables.
     * @param type Item Type is describing which kind of item this is.
     * @param role Character role (Mage, Ranger, Rogue etc...).
     * @param slot Armor/Weapon slot.
     */
    public Item(String name, int level, int value, ItemType type, Role role, Slot slot) {
        this.name = name;
        this.level = level;
        this.value = value;
        this.type = type;
        this.role = role;
        this.slot = slot;
    }

    /**
     * Get Item name.
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set Item name.
     * @param name name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get Item Level (Or 'Required Level').
     * @return item level.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Set Item Level (Or 'Required Level').
     * @param level item level.
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Get Value, or Consumable efficiency/strength etc.
     * @return value.
     */
    public int getValue() {
        return value;
    }

    /**
     * Set Value, or Consumable efficiency/strength etc.
     * @param value value.
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Get Item Type, Equipment or Healing (Consumable).
     * @return ItemType type.
     */
    public ItemType getType() {
        return type;
    }

    /**
     * Set Item Type, Equipment or Healing (Consumable).
     * @param type ItemType type.
     */
    public void setType(ItemType type) {
        this.type = type;
    }

    /**
     * Get Character Role used to identify armor/weapon type.
     * @return role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Set Character Role used to identify armor/weapon type.
     * @param role role.
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Get Equipment Slot used to identify equipment slot on character.
     * @return Equipment slot.
     */
    public Slot getSlot() {
        return slot;
    }

    /**
     * Set Equipment Slot used to identify equipment slot on character.
     * @param slot Equipment slot.
     */
    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    @Override
    public String toString() {
        if(role == null) {
            return name + " { " +
                    "Level = " + level +
                    ", Value = " + value +
                    ", Type = " + type +
                    " }";
        }
        return name + " { " +
                "Level = " + level +
                ", Type = " + type +
                ", Role = " + role +
                " }";
    }
}
