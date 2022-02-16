import controller.Controller;
import controller.StateManager;
import model.State;

public class Main {

    /**
     * Main method to start.
     * Required in all Java Applications.
     * @param args default arguments
     */
    public static void main(String[] args) {
        // Initialize Singletons (Only one instance)
        StateManager stateManager = StateManager.getInstance();
        Controller controller = Controller.getInstance();

        // Go through setup process in StateManager, step-by-step.
        stateManager.handleState(controller, State.Controller.Initialize);
        stateManager.handleState(controller, State.Controller.Start);
        stateManager.handleState(controller, State.Controller.Update);
    }
}
