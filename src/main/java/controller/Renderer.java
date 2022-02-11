package controller;

public class Renderer {
    private static Renderer instance = null;

    private Renderer() {}

    public static Renderer getInstance() {
        if(instance == null) { instance = new Renderer(); }
        return instance;
    }

    public void update() {

    }

    public void render() {

    }
}
