package com.quickmathstudios.dieelite.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.quickmathstudios.dieelite.main.GameMain;
import com.quickmathstudios.dieelite.main.Info;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Info.Width;
		config.height = Info.Height;
		config.title = "Die Elite";
		config.addIcon("icon128.png",Files.FileType.Internal);
		config.addIcon("icon32.png",Files.FileType.Internal);
		config.addIcon("icon16.png",Files.FileType.Internal);
		new LwjglApplication(new GameMain(), config);
	}
}
