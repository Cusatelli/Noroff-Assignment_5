package model;

public class State {
    private static Controller controllerState = Controller.Initialize;
    private static Input inputState = Input.Menu;

    public enum Controller {
        Error,
        Initialize,
        Start,
        Update,
        Exit,
        Terminate
    }

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

    public enum CombatState {
        Escape, // Important that escape always is 0
        Attack,
        Heal,
        Stats,
        Inventory,
        Equipment;

        public static CombatState get(int index) {
            return CombatState.values()[index];
        }
    }

    public enum InteractState {
        Leave, // Important that leave always is 0
        Shop,
        Stats,
        Inventory,
        Equipment;

        public static InteractState get(int index) {
            return InteractState.values()[index];
        }
    }

    public static void setInputState(Input state) {
        inputState = state;
    }

    public static Input getInputState() {
        return inputState;
    }

    public static void setControllerState(Controller state) {
        controllerState = state;
    }

    public static Controller getControllerState() {
        return controllerState;
    }
}
