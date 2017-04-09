package gk.quiz.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Marcin on 2016-07-20.
 */
public class Game {
    private SpriteBatch batch;
    private Texture logo, box, boxOK, boxBad, questionsField;
    private ArrayList<Question> questions;
    private Question actualQuestion;
    private BitmapFont font;
    private int selected = -1;
    private float timer, timerAfterClick;
    private Quiz quiz;
    private XML xml;

    Game(SpriteBatch batch, Quiz quiz) {
        this.batch = batch;
        this.quiz = quiz;

        box = new Texture("image/box.png");
        boxOK = new Texture("image/box_ok.png");
        boxBad = new Texture("image/box_bad.png");
        questionsField = new Texture("image/questionfield.png");
        questions = new ArrayList<Question>();
        font = new BitmapFont(Gdx.files.internal("image/segoe.fnt"));
        xml = new XML(questions);
    }

    public void render() {
        if (actualQuestion.isImage()) {
            batch.draw(actualQuestion.getImg(), 50, 150);
        }

        for (int i = 0; i < 4; i++) {
            if(i != selected) {
                if(!actualQuestion.isCorrect(i) || selected == -1) {
                    batch.draw(box, 350, (50 + 125*(i)));
                }
            }
            else if(actualQuestion.isCorrect(selected)) {
                batch.draw(boxOK, 350, (50 + 125*(i)));
            }
            else {
                batch.draw(boxBad, 350, (50 + 125*(i)));
                for (int j = 0; j < 4; j++) {
                    if(actualQuestion.isCorrect(j)) {
                        batch.draw(boxOK, 350, (50 + 125*(j)));
                        font.draw(batch, actualQuestion.getAns(j), 400, (100 + 125*j));
                    }
                }
            }
            font.draw(batch, actualQuestion.getAns(i), 400, (100 + 125*i));
        }
        batch.draw(questionsField, 50, 550);
        font.draw(batch, actualQuestion.getQuestionText(), 100, 620);
        font.draw(batch, "Czas: " + Math.round(timer) , 1100, 620);
        update();
    }

    public void update() {
        if(selected == -1) timer += Gdx.graphics.getDeltaTime();

        if(Gdx.input.isTouched() && selected == -1) {
            int x = Gdx.input.getX();
            int y = 650 - Gdx.input.getY();
            System.out.println(x + " " + y);

            if (x > 400 && y > 50 && y < 550) {
                x -=400;
                y -=50;
                if (y % 125 < 100) {
                    System.out.println(y / 125);
                    selected = y / 125;
                    timerAfterClick = 0;
                }
            }
        }

        if (selected != -1) {
            timerAfterClick += Gdx.graphics.getDeltaTime();
            if (timerAfterClick >= 1) {
                int toAdd = 0;
                quiz.selectMode(2);
                if (actualQuestion.isCorrect(selected)) toAdd = 100;
                quiz.getStats().updateData(toAdd);
                quiz.getStats().resetTimer();
            }
        }
    }


    public void randomQuestion() {

        timer = 0;
        selected = -1;
        Random rand = new Random();
        int randq = rand.nextInt(questions.size());
        actualQuestion = questions.get(randq);
    }
}
