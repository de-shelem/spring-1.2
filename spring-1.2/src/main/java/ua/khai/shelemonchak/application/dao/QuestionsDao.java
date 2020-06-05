package ua.khai.shelemonchak.application.dao;

import java.io.IOException;
import java.util.LinkedList;

public interface QuestionsDao {
    public LinkedList<String> questions = new LinkedList<String>();
    public LinkedList<String> answers = new LinkedList<String>();

    public void input(String fileName) throws IOException;

    public LinkedList<String> getQuestions();

    public LinkedList<String> getAnswers();

    public void setQuestions(LinkedList<String> questions);

    public void setAnswers(LinkedList<String> answers) ;

}
