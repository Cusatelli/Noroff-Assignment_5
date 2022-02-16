package controller.units;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NPCTest {
    private NPC npc;

    @BeforeEach
    void setUp() {
        npc = NPC.getInstance();
    }

    @Test
    void GetInstance_ReturnSingletonInstanceOfNPC() {
        npc = null;
        npc = NPC.getInstance();
        assertNotNull(npc);
    }

    @Test
    void SetIntroduction_AddIntroductionToNPC() {
        npc.setIntroduction("Hello there fellow adventurer!");
        assertSame("Hello there fellow adventurer!", npc.getIntroduction());
    }
}