package exception;

import model.State;

public class StateException extends Exception {
    public StateException(String message) {
        super(message);
    }

    public StateException(State.Controller state, Class<?> c) {
        super("Could not resolve State(Controller) -> " + state + " in, " + c.getName());
    }

    public StateException(State.Input state, Class<?> c) {
        super("Could not resolve State(Input) -> " + state + " in, " + c.getName());
    }
}
