package com.g16.feyrune;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.g16.feyrune.Feyrune;
import com.g16.feyrune.map.Map;
import com.g16.feyrune.model.Parser.MapParser;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Feyrune");
		new Lwjgl3Application(new Feyrune(), config);
	}
}
