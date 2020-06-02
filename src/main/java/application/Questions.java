package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Questions {

    //конструктор, считывает данные с файла questions.csv
    private final String FILE_NAME = "questions.csv";

    public Questions() throws IOException {
        File file = new File(FILE_NAME);
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

