package controller;

import model.Options;
import model.State;
import view.Display;

public class Controller {
    private static Controller instance = null;
    private State state = State.Error;
    private Options optionState = Options.Menu;
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
        this.state = State.Start;
    }

    public void start() {
        this.state = State.Update;
    }

    void update() {
        long lastTime = System.nanoTime();
        double updatesPerSecond = 10.0;
        double nanoSeconds = 1000000000 / updatesPerSecond;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frameCounter = 0;
        while (this.state.equals(State.Update)) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nanoSeconds;
            lastTime = now;
            while (delta >= 1) {
                renderer.update();
                delta--;
            }
            if(this.state.equals(State.Update)) {
                inputHandler.interpreter(optionState);
                renderer.render();
            }
            frameCounter++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                Display.loading();
                frameCounter = 0;
            }
        }
        exit();
    }

    public void exit() {
        this.state = State.Terminate;
    }

    public void terminate() {
        System.exit(1);
    }
}
