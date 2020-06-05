package com.khai.shelemonchak.dao;

import java.io.IOException;
import java.util.LinkedList;

public interface QuestionsDao {

    public void input(String fileName) throws IOException;

    public LinkedList<String> getQuestions();

    public LinkedList<String> getAnswers();

    public LinkedList<String> questions = new LinkedList<String>();
    public LinkedList<String> answers = new LinkedList<String>();
}
