package ua.khai.shelemonchak.application.dao;

import java.io.IOException;
import java.util.LinkedList;

public interface QuestionsDao {

    void input(String fileName) throws IOException;

    LinkedList<String> getQuestions();

    LinkedList<String> getAnswers();

    void setQuestions(LinkedList<String> questions);

    void setAnswers(LinkedList<String> answers);

    LinkedList<String> questions = new LinkedList<String>();
    LinkedList<String> answers = new LinkedList<String>();
}
