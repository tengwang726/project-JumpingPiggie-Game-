package com.tengwang.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.tengwang.game.JumpingGDemo;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width=JumpingGDemo.WIDTH;
		config.height=JumpingGDemo.HEIGHT;
		config.title=JumpingGDemo.TITLE;
		new LwjglApplication(new JumpingGDemo(), config);
	}
}
