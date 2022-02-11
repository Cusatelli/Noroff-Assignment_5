import controller.Controller;
import controller.StateManager;
import model.State;

public class Main {
    private boolean isRunning = true;

    public static void main(String[] args) {
        StateManager stateManager = StateManager.getInstance();
        Controller controller = Controller.getInstance();

        stateManager.handleState(controller, State.Initialize);
        stateManager.handleState(controller, State.Start);
        stateManager.handleState(controller, State.Update);
    }
}
