package com.summative.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.summative.game.Platform;

public class DesktopLauncher {
	public static void main (String[] arg) {
                         
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                
                // Configuring the screen size
                config.width = 800;
                config.height = 600;
                
		new LwjglApplication(new Platform(), config);
	}
}