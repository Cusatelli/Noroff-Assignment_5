package model.character;

import controller.units.Player;
import model.item.Item;
import model.item.equipment.Armor;
import model.item.equipment.Equipped;
import model.item.equipment.Slot;
import model.item.equipment.Weapon;
import model.item.equipment.set.cloth.Cloth;
import model.item.equipment.set.leather.Leather;
import model.item.equipment.set.mail.Mail;
import model.item.equipment.weapon.axe.AdeptAxe;
import model.item.equipment.weapon.staff.NoviceStaff;
import model.role.Rogue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
    private Player player;

    @BeforeEach
    void setUp() {
        this.player = Player.getInstance();
        this.player.initialize(Role.Mage); // Overwrites Equipment
    }

    @AfterEach
    void tearDown() {
        this.player.setInventory(new ArrayList<>()); // Empties Inventory
    }

    @Test
    void GetEquipment_HasStarterWeapon_NotNull() {
        Weapon playerWeapon = player.getEquipment().getWeapon();

        assertNotNull(playerWeapon);
    }

    @Test
    void GetEquipment_HasStarterArmor_NotNull() {
        Armor playerArmor = player.getEquipment().getHead();

        assertNotNull(playerArmor);
    }

    @Test
    void GetInventory_HasNoItems_IsEmpty() {
        boolean inventoryIsEmpty = player.getInventory().isEmpty();

        assertTrue(inventoryIsEmpty);
    }

    @Test
    void GetInventory_HasPotion_IsNotEmpty() {
        Item potion = new Item("Potion", 1, 5, Item.ItemType.Healing);
        player.addItemToInventory(potion);
        boolean inventoryIsEmpty = player.getInventory().isEmpty();

        assertFalse(inventoryIsEmpty);
    }

    @Test
    void GetFirstItemOfType_ItemTypeHealing_Potion() {
        Item potion = new Item("Potion", 1, 10, Item.ItemType.Healing);
        Item bodyArmor = new Item("Armor", 1, 10, Item.ItemType.Equipment, Role.Mage, Slot.Body);
        player.addItemToInventory(bodyArmor);
        player.addItemToInventory(potion);
        Item firstItem = player.getFirstItemOfType(Item.ItemType.Healing);

        assertSame(potion, firstItem);
    }

    @Test
    void SetEquipment_EquipValidAdeptArmorSet_IsEquipped() {
        Armor[] armor = Cloth.Adept.Set();
        player.setEquipment(new Equipped(armor, new NoviceStaff()));
        Armor playerArmor = player.getEquipment().getHead();

        assertSame(armor[0], playerArmor);
    }

    @Test
    void LevelUp_HasEnoughExperienceToLevelUpOnce_LevelUpToTwo() {
        int exp = 5;
        player.levelUp(exp);
        int playerLevel = player.getLevel();

        assertEquals(2, playerLevel);
    }

    @Test
    void LevelUp_HasEnoughExperienceToLevelUpTwice_LevelUpToThree() {
        player.levelUp(5);
        player.levelUp(10);
        int playerLevel = player.getLevel();

        assertEquals(3, playerLevel);
    }

    @Test
    void LevelUp_ExperienceCarriesOverLevels_LevelOneWithExtraExp() {
        player.levelUp(9); // Requires total 5 exp
        player.levelUp(6); // Requires total 15 exp
        int playerLevel = player.getLevel();

        assertEquals(3, playerLevel);
    }

    @Test
    void GetStats_PlayerHasAttributesOnInitialization_RogueStats() {
        player.initialize(Role.Rogue);
        assertTrue(player.getStats().getBaseAttributes().getStrength() == Rogue.Stats().getBaseAttributes().getStrength()
                && player.getStats().getTotalAttributes().getDexterity() == Rogue.Stats().getTotalAttributes().getDexterity()
                && player.getStats().getTotalAttributes().getIntelligence() == Rogue.Stats().getTotalAttributes().getIntelligence()
                && player.getStats().getTotalAttributes().getResilience() == Rogue.Stats().getTotalAttributes().getResilience()
        );
    }

    @Test
    void Initialize_PlayerInitializeRoleDeprived_RoleIsDeprived() {
        Role role = Role.Deprived;
        player.initialize(role);
        Role playerRole = player.getRole();

        assertSame(role, playerRole);
    }

    @Test
    void SetSilver_PlayerWalletHasCorrectAmountOfSilver_ExpectedTwo() {
        player.setSilver(5);
        player.setSilver(2);
        int playerSilver = player.getSilver();

        assertEquals(2, playerSilver);
    }

    @Test
    void GetDamage_PlayerCorrectlyCalculateWeaponTotalDamage_ExpectTwentySix() {
        player.initialize(Role.Warrior);
        player.getEquipment().setWeapon(new AdeptAxe());
        double playerDamage = player.getDamage();

        assertEquals(26.73, playerDamage);
    }

    @Test
    void GetDamage_PlayerCorrectlyCalculateArmorTotalDamage_ExpectTwentySix() {
        player.initialize(Role.Rogue);
        player.getEquipment().setHead(Leather.Adept.Head());
        player.getEquipment().setBody(Mail.Adept.Body());
        player.getEquipment().setLegs(Leather.Adept.Legs());
        double playerDamage = player.getDamage();

        assertEquals(11.628, playerDamage);
    }

    @Test
    void TakeDamage_PlayerTakeDamageFromEnemy() {
        player.takeDamage(15);
        int playerHealth = player.getHealth();

        assertEquals(85, playerHealth);
    }

    @Test
    void ReplenishHealth_PlayerHealHealth() {
        player.takeDamage(12);
        player.replenishHealth(8);
        int playerHealth = player.getHealth();

        assertEquals(96, playerHealth);
    }

    @Test
    void ReplenishHealth_PlayerHealBeyondMaxHealth_ClampMaxHealth() {
        player.takeDamage(10);
        player.replenishHealth(50);
        int playerHealth = player.getHealth();

        assertEquals(100, playerHealth);
    }
}