package com.khai.shelemonchak.services;

import com.khai.shelemonchak.dao.QuestionsDaoCvs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class TestsServicesImpl implements TestsServices {
    //конструктор
    public TestsServicesImpl(QuestionsDaoCvs myQuestions) {
        this.myQuestions = myQuestions;
    }


    public void runTest() {// метод запускающий тест
        result = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("print yor name:");
        name = scanner.nextLine();
        System.out.println("Print yor surname:");
        surname = scanner.nextLine();

        System.out.println("Hello " + name + " " + surname + ", start the test!");
        Iterator myQuestionsIterator = myQuestions.getQuestions().iterator();
        myAnswers= new LinkedList<String>();
        for(;myQuestionsIterator.hasNext();) {
            System.out.println(myQuestionsIterator.next());
            myAnswers.add(scanner.nextLine());
        }
        Iterator myAnswersIter = myAnswers.iterator();
        Iterator AnswersIter = myQuestions.getAnswers().iterator();
        for (; myAnswersIter.hasNext() && AnswersIter.hasNext(); ) {

            result += myAnswersIter.next().equals(AnswersIter.next()) ? 1 : 0;
        }

        System.out.println("End.");
    }


    public QuestionsDaoCvs getMyQuestions() {
        return myQuestions;
    }


    public void getScore() {
        System.out.println();
        Iterator myAnswersIter = myAnswers.iterator();
        Iterator AnswersIter = myQuestions.getAnswers().iterator();
        int i = 0;
        for (;myAnswersIter.hasNext();)
            System.out.println("Questions # " + (++i) + " - " +(myAnswersIter.next().equals(AnswersIter.next()) ? 1 : 0));
        System.out.println("Your result is "+result);
    }


    private QuestionsDaoCvs myQuestions;// Экземпляр класа myQuestions


    private LinkedList myAnswers; // результат прохождения теста


    private String name; //имя пользователя


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    private int result = 0;
    private String surname; // фамилия пользователя
}
