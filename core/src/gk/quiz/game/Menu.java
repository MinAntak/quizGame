package gk.quiz.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Marcin on 2016-07-20.
 */
public class Menu {
    SpriteBatch batch;
    private Texture button, info;
    private BitmapFont font;
    private Quiz quiz;
    Menu(SpriteBatch batch, Quiz quiz) {
        this.batch = batch;
        this.quiz = quiz;
        font = new BitmapFont(Gdx.files.internal("image/segoe.fnt"));
        button = new Texture("image/box.png");
        info = new Texture("image/info.png");
    }

    void render() {
        batch.draw(info, 200, 300);
        batch.draw(button, 200, 50);
        font.draw(batch, "Quiz", 585, 550);
        font.draw(batch, "Czy jesteś w stanie odpowiedzieć na 10 pytań?", 225, 450);
        font.draw(batch, "Sprawdź się!", 520, 400);

        font.draw(batch, "Start", 575, 110);
        update();
    }

    public void update() {
        if(Gdx.input.isTouched()) {
            int x = Gdx.input.getX();
            int y = 650 - Gdx.input.getY();
            System.out.println(x + " " + y);

            if (x > 200 && y > 50 && y < 150 && x < 1050) {
                System.out.println("Start");
                quiz.selectMode(2);
                quiz.getGame().randomQuestion();
                }
            }
    }
}

