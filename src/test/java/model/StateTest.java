package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StateTest {
    @Test
    void InputState_SetStateToGame_GetStateGame() {
        State.setInputState(State.Input.Game);
        State.Input inputState = State.getInputState();

        assertEquals(State.Input.Game, inputState);
    }

    @Test
    void ControllerState_SetStateToUpdate_GetStateUpdate() {
        State.setControllerState(State.Controller.Update);
        State.Controller controllerState = State.getControllerState();

        assertEquals(State.Controller.Update, controllerState);
    }
}