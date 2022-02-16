package model.item.equipment;

import controller.units.Player;
import model.character.Role;
import model.item.Item;
import model.item.equipment.set.leather.Leather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquippedTest {
    private Player player;

    @BeforeEach
    void setUp() {
        player = Player.getInstance();
        player.initialize(Role.Rogue);
    }

    @Test
    void Set() {
        Item item = Leather.Adept.Head();
        player.getEquipment().set(item);
        item.setSlot(Slot.Head);
        Item equippedItem = player.getEquipment().getHead();

        assertEquals(item, equippedItem);
    }
}