package gk.quiz.game;

import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

/**
 * Created by Marcin on 2016-07-20.
 */
class Question {
    private int id;
    private int number;
    private int diff, isImg;
    private String questionText;
    private String ansA, ansB, ansC, ansD;
    private int idA, idB, idC, idD;
    private int[] isUsed;
    private String[] ans;
    private int[] ansId;
    private Texture img;

    Question(int id, int number, int diff, int isImg, String text,
             String ansA, String ansB, String ansC, String ansD, int idA, int idB, int idC, int idD) {
        isUsed = new int[4];
        ans = new String[4];
        ansId = new int[4];
        for (int i = 0; i < 4; i++) isUsed[i] = -1;
        this.id = id;
        this.number = number;
        this.diff = diff;
        this.ansA = ansA;
        this.ansB = ansB;
        this.ansC = ansC;
        this.ansD = ansD;
        this.idA = idA;
        this.idB = idB;
        this.idC = idC;
        this.idD = idD;
        this.isImg = isImg;
        questionText = text;

        if (isImg == 1) {
            img = new Texture("image/questions/"+number+".jpg");
        }
        else {
            img = null;
        }
        for (int i = 0; i < 4; i++) randomize(i);
    }

    private void randomize(int number) {
        Random rand = new Random();
        int randNumber = rand.nextInt(4);
        if (isUsed[randNumber] == -1) {
            isUsed[randNumber] = number;
            switch (number) {
                case 0:
                    ans[randNumber] = ansA;
                    ansId[randNumber] = idA;
                    break;
                case 1:
                    ans[randNumber] = ansB;
                    ansId[randNumber] = idB;
                    break;
                case 2:
                    ans[randNumber] = ansC;
                    ansId[randNumber] = idC;
                    break;
                case 3:
                    ans[randNumber] = ansD;
                    ansId[randNumber] = idD;
                    break;
                default:
                    break;
            }
        }
        else randomize(number);
    }

    public int getId() { return id; }

    public int getNumber() { return number; }

    public int getDiff() { return diff; }

    public String getAns(int number) {
        return ans[number];
    }

    public int getAnsId(int number) {
        return ansId[number];
    }

    public String getQuestionText() { return questionText; }

    public boolean isCorrect(int numb) {
        if((((3 * id) + (45 * diff))*542) % 34519 + 6 * number == ansId[numb]) {
            return true;
        }
        else return false;
    }

    public boolean isImage() {
        if (isImg == 0) return false;
        else return true;
    }
    public Texture getImg() { return img;}
}
