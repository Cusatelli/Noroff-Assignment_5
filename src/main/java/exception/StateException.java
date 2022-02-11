package exception;

import model.Options;
import model.State;

public class StateException extends Exception {
    public StateException(String message) {
        super(message);
    }

    public StateException(State state, Class<?> c) {
        super("Could not resolve State -> " + state + " in, " + c.getName());
    }
    public StateException(Options state, Class<?> c) {
        super("Could not resolve State(Option) -> " + state + " in, " + c.getName());
    }
}
