package model;

public class State {
    private static Controller controllerState = Controller.Initialize;
    private static Input inputState = Input.Menu;

    /**
     * Keep track of Controller States for updating the game loop.
     */
    public enum Controller {
        Error,
        Initialize,
        Start,
        Update,
        Exit,
        Terminate
    }

    /**
     * Keep track of Input State to know where to direct the user in console.
     */
    public enum Input {
        Menu,
        Start,
        CreateCharacter,
        Game,
        Combat,
        Interact,
        Exit,
        Terminate
    }

    /**
     * Combat State to make switches more readable (Replaced 0-5 switch).
     */
    public enum CombatState {
        Escape, // Important that escape always is 0
        Attack,
        Heal,
        Stats,
        Inventory,
        Equipment;

        /**
         * Get the index of Combat States.
         * Escape is always returned at 0.
         * @param index which CombatState (in order) to return.
         * @return CombatState
         */
        public static CombatState get(int index) {
            return CombatState.values()[index];
        }
    }

    /**
     * Interact State to make switches more readable (Replaced 0-4 switch).
     */
    public enum InteractState {
        Leave, // Important that leave always is 0
        Shop,
        Stats,
        Inventory,
        Equipment;

        /**
         * Get the index of Interact States.
         * Leave is always returned at 0.
         * @param index which InteractState (in order) to return.
         * @return InteractState
         */
        public static InteractState get(int index) {
            return InteractState.values()[index];
        }
    }

    /**
     * Set Input State based on where the user shall be redirected after it's previous action.
     * @param state enum of Input State.
     */
    public static void setInputState(Input state) {
        inputState = state;
    }

    /**
     * Get Input State based.
     * @return Input (State)
     */
    public static Input getInputState() {
        return inputState;
    }

    /**
     * Set Controller State based on what state the "Engine"/Controller is in..
     * @param state enum of Controller State.
     */
    public static void setControllerState(Controller state) {
        controllerState = state;
    }

    /**
     * Get current Controller State.
     * @return Controller (State)
     */
    public static Controller getControllerState() {
        return controllerState;
    }
}
