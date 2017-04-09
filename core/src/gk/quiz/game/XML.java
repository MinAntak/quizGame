package gk.quiz.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Marcin on 2016-07-21.
 */
public class XML {
    ArrayList<Question> questions;

    XML(ArrayList<Question> questions) {
        this.questions = questions;
        action();
    }

    void action() {
        int id, number, diff, idA, idB, idC, idD, imag;
        String text, ansA, ansB, ansC, ansD;

        XmlReader xml = new XmlReader();
        XmlReader reader = new XmlReader();
        Element root = null;
        try {
            root = reader.parse(Gdx.files.internal("image/data.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Array<Element> items = root.getChildrenByName("question");
        for (Element child : items)
        {
            id = Integer.parseInt(child.getChildByName("id").getText());
            number = Integer.parseInt(child.getChildByName("number").getText());
            diff = Integer.parseInt(child.getChildByName("diff").getText());
            text = child.getChildByName("text").getText();
            imag = Integer.parseInt(child.getChildByName("imag").getText());
            ansA = child.getChildByName("ansA").getText();
            ansB = child.getChildByName("ansB").getText();
            ansC = child.getChildByName("ansC").getText();
            ansD = child.getChildByName("ansD").getText();
            idA = Integer.parseInt(child.getChildByName("idA").getText());
            idB = Integer.parseInt(child.getChildByName("idB").getText());
            idC = Integer.parseInt(child.getChildByName("idC").getText());
            idD = Integer.parseInt(child.getChildByName("idD").getText());

            //System.out.print(imag);
            questions.add(new Question(id, number, diff, imag, text,
                    ansA, ansB, ansC, ansD, idA, idB,idC ,idD));
        }
    }

}
