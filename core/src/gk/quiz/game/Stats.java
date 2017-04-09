package gk.quiz.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Marcin on 2016-07-20.
 */
public class Stats {
    private int score;
    private int question;
    private SpriteBatch batch;
    private Texture info;
    private Quiz quiz;
    private float timer;
    private BitmapFont font;

    Stats(SpriteBatch batch, Quiz quiz) {
        this.batch = batch;
        this.quiz = quiz;
        score = 0;
        question = 1;
        info = new Texture("image/info.png");
        font = new BitmapFont(Gdx.files.internal("image/segoe.fnt"));
    }

    void render() {
        batch.draw(info, 400, 150);
        font.draw(batch, "Wynik: " + score, 450, 250);
        font.draw(batch, "Pytania: " + question + "/10", 450, 350);
        update();
    }

    void update() {
        timer += Gdx.graphics.getDeltaTime();
        if (timer > 2) {
            quiz.getGame().randomQuestion();
            quiz.selectMode(1);
        }

    }

    void updateData(int addScore) {
        question++;
        score += addScore;
    }

    void resetTimer() { timer = 0; }


}
