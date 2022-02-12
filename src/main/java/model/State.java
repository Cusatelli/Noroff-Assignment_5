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
        Combat,
        Interact,
        Exit,
        Terminate
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
