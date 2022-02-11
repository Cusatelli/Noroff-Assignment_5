package controller;

import exception.StateException;
import model.State;

public class StateManager {
    private static StateManager instance = null;

    private StateManager() {}

    public static StateManager getInstance() {
        if(instance == null) { instance = new StateManager(); }
        return instance;
    }

    public void handleState(Controller controller, State state) {
        switch (state) {
            case Initialize -> { controller.initialize(); }
            case Start -> {
                controller.start();
            }
            case Update -> { controller.update(); }
            case Exit -> { controller.exit(); }
            case Terminate -> { controller.terminate(); }
            case Error -> {
                try { throw new StateException(state, getClass()); }
                catch (StateException e) { e.printStackTrace(); }
            }
        }
    }
}
