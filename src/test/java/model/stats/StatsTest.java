package model.stats;

import model.role.Mage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatsTest {
    private Stats stats;

    @BeforeEach
    void setUp() {
        stats = Mage.Stats();
    }

    @Test
    void Level_SetLevelTwo_GetLevelTwo() {
        stats.setLevel(2);
        int level = stats.getLevel();

        assertEquals(2, level);
    }

    @Test
    void MaxHealth_SetMaxHealthFifty_GetMaxHealthFifty() {
        stats.setMaxHealth(50);
        int maxHealth = stats.getMaxHealth();

        assertEquals(50, maxHealth);
    }

    @Test
    void CurrentHealth_SetCurrentHealthSeventyFive_GetCurrentHealthSeventyFive() {
        stats.setCurrentHealth(75);
        int currentHealth = stats.getCurrentHealth();

        assertEquals(75, currentHealth);
    }

    @Test
    void BaseAttributes_GetStatDefaultsFromMage() {
        Attributes baseAttributes = stats.getBaseAttributes();
        int baseStr = baseAttributes.getStrength();
        int baseDex = baseAttributes.getDexterity();
        int baseInt = baseAttributes.getIntelligence();
        int baseRes = baseAttributes.getResilience();

        Attributes attributes = new Attributes(1, 1, 8, 0);
        int str = attributes.getStrength();
        int dex = attributes.getDexterity();
        int intelligence = attributes.getIntelligence();
        int res = attributes.getResilience();

        assertTrue(str == baseStr && dex == baseDex
                && intelligence == baseInt && res == baseRes);
    }

    @Test
    void TotalAttributes_GetStatDefaultsFromMage() {

        Attributes totalAttributes = stats.getTotalAttributes();
        int totalStr = totalAttributes.getStrength();
        int totalDex = totalAttributes.getDexterity();
        int totalInt = totalAttributes.getIntelligence();
        int totalRes = totalAttributes.getResilience();

        Attributes attributes = new Attributes(1, 1, 8, 0);
        int str = attributes.getStrength();
        int dex = attributes.getDexterity();
        int intelligence = attributes.getIntelligence();
        int res = attributes.getResilience();

        assertTrue(str == totalStr && dex == totalDex
                && intelligence == totalInt && res == totalRes);
    }

    @Test
    void RequiredExperience_AtLevelOneRequiresFiveExp() {
        int requiredExp = stats.getRequiredExperience();

        assertEquals(5, requiredExp); // Level 1 wants 5 exp.
    }

    @Test
    void CurrentExperience_AtReceivedFiftyExp_HaveFiftyExp() {
        stats.setCurrentExperience(50);
        int currentExperience = stats.getCurrentExperience();

        assertEquals(50, currentExperience);
    }

    @Test
    void LevelUp_EnoughExpProvided_Success() {
        boolean hasLeveledUp = stats.levelUp(5);

        assertTrue(hasLeveledUp); // At Level 1 5 is exp needed.
    }

    @Test
    void LevelUp_NotEnoughExpProvided_Fail() {
        boolean hasLeveledUp = stats.levelUp(3);

        assertFalse(hasLeveledUp); // At Level 1 5 is exp needed.
    }
}
