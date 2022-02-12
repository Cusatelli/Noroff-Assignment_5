package controller;

import model.State;
import view.Display;

public class Controller {
    private static Controller instance = null;
    private Renderer renderer;
    private InputHandler inputHandler;

    private Controller() {}

    public static Controller getInstance() {
        if(instance == null) { instance = new Controller(); }
        return instance;
    }

    public void initialize() {
        this.renderer = Renderer.getInstance();
        this.inputHandler = InputHandler.getInstance();

        // When done... move on
        State.setControllerState(State.Controller.Start);
    }

    public void start() {
        Display.welcome();
        Display.options(State.Input.Menu);
        State.setControllerState(State.Controller.Update);
    }

    void update() {
        long lastTime = System.nanoTime();
        double updatesPerSecond = 10.0;
        double timeInNanoSeconds = 1000000000 / updatesPerSecond;
        double delta = 0;
        long timer = System.currentTimeMillis();
        while (State.getControllerState().equals(State.Controller.Update)) {
            long currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / timeInNanoSeconds;
            lastTime = currentTime;

            while (delta >= 1) { // Delta Update Loop
                renderer.update();
                delta--;
            }

            if(State.getControllerState().equals(State.Controller.Update)) { // Continue of still running
                String input = this.inputHandler.listen();
                this.inputHandler.interpreter(input);
                this.renderer.render();
            }

            if(System.currentTimeMillis() - timer > 1000) { // Update Time
                timer += 1000;
            }
        }
        exit(); // When Loop has finished, Exit
    }

    public void exit() {
        State.setInputState(State.Input.Terminate);
        State.setControllerState(State.Controller.Terminate);
    }

    public void terminate() {
        System.exit(1);
    }
}
