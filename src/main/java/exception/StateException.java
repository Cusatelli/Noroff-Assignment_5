package exception;

import model.State;

/**
 * Exception to throw whenever a State can not be set.
 */
public class StateException extends Exception {

    /**
     * Default exception to throw.
     * @param message custom exception message.
     */
    public StateException(String message) {
        super(message);
    }

    /**
     * Custom exception to throw.
     * @param state The state which can not be resolved.
     * @param c class name.
     */
    public StateException(State.Controller state, Class<?> c) {
        super("Could not resolve State(Controller) -> " + state + " in, " + c.getName());
    }

    /**
     * Custom exception to throw.
     * @param state The state which can not be resolved.
     * @param c class name.
     */
    public StateException(State.Input state, Class<?> c) {
        super("Could not resolve State(Input) -> " + state + " in, " + c.getName());
    }
}
