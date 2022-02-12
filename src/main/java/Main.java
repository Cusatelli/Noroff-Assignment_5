import controller.Controller;
import controller.StateManager;
import model.State;

public class Main {
    public static void main(String[] args) {
        StateManager stateManager = StateManager.getInstance();
        Controller controller = Controller.getInstance();

        stateManager.handleState(controller, State.Controller.Initialize);
        stateManager.handleState(controller, State.Controller.Start);
        stateManager.handleState(controller, State.Controller.Update);
    }
}
