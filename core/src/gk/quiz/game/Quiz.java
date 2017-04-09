package gk.quiz.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Quiz extends ApplicationAdapter {
	private SpriteBatch batch;
	private Game game;
	private Menu menu;
	private Stats stats;
	private int mode;

	@Override
	public void create () {
		batch = new SpriteBatch();
		game = new Game(batch, this);
		menu = new Menu(batch, this);
		stats = new Stats(batch, this);
		mode = 0;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//Start draw
		batch.begin();
		if (mode == 0) menu.render();
		else if (mode == 1) game.render();
		else if (mode == 2) stats.render();
		batch.end();
	}

	public void selectMode(int number) {
		mode = number;
	}

	public Game getGame() { return game; }

	public Stats getStats() { return stats; }



}
