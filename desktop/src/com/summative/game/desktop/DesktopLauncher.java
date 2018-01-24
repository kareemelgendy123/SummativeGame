package com.summative.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.summative.game.Asteroids;

public class DesktopLauncher {
	public static void main (String[] arg) {
                         
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                
                // Configuring the screen 
                config.title = "Asteroids";
                config.width = 800;
                config.height = 600;
                
		new LwjglApplication(new Asteroids(), config);
	}
}