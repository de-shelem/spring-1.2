package ua.khai.shelemonchak.application.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;
import ua.khai.shelemonchak.application.dao.settings.QuestionsDaoSettingLoader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

@EnableAspectJAutoProxy
@Repository
public class QuestionsDaoCvs implements QuestionsDao {

    @Autowired
    public QuestionsDaoCvs(QuestionsDaoSettingLoader questionsDaoSettingLoader) throws IOException {
        this.input(questionsDaoSettingLoader.getFILE_NAME());
    }

    public void input(String fileName) throws IOException {

        File file = new File(fileName);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = null;
        Scanner scanner = null;
        int index = 0;

        while ((line = bufferedReader.readLine()) != null) {
            scanner = new Scanner(line);
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                String str = scanner.next();
                questions.add(str);
                str = scanner.next();
                answers.add(str);
            }
        }
    }

    public LinkedList<String> getQuestions() {
        return questions;
    }

    public LinkedList<String> getAnswers() {
        return answers;
    }

    public void setQuestions(LinkedList<String> questions) {
        this.questions = questions;
    }

    public void setAnswers(LinkedList<String> answers) {
        this.answers = answers;
    }

    private LinkedList<String> questions = new LinkedList<String>();
    private LinkedList<String> answers = new LinkedList<String>();

}

