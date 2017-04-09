package gk.quiz.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import gk.quiz.game.Quiz;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Quiz";
		config.width = 1280;
		config.height = 650;
		new LwjglApplication(new Quiz(), config);
	}
}
