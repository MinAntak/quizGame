package gk.quiz.game.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import gk.quiz.game.Quiz;

public class HtmlLauncher extends GwtApplication {

        @Override
        public GwtApplicationConfiguration getConfig () {
                return new GwtApplicationConfiguration(1280, 650);
        }

        @Override
        public ApplicationListener createApplicationListener () {
                return new Quiz();
        }
}