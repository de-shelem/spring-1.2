package com.khai.shelemonchak.dao;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class QuestionsDaoCvs implements QuestionsDao {

    public QuestionsDaoCvs(String FileName) throws IOException {
        this.input(FileName);
    }

    @Override
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

    private LinkedList<String> questions = new LinkedList<String>();
    private LinkedList<String> answers = new LinkedList<String>();

}

