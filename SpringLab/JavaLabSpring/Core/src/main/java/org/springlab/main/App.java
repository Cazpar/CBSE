package org.springlab.main;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class App
{
    public static void main(String[] args) {
        LwjglApplicationConfiguration cfg =
                new LwjglApplicationConfiguration();
        cfg.title = "Asteroids";
        cfg.width = 1280;
        cfg.height = 960;
        cfg.useGL30 = false;
        cfg.resizable = false;
        
        new LwjglApplication(new Game(), cfg);
    }
}
