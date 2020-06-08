package ua.khai.shelemonchak.application.services.testing;

import ua.khai.shelemonchak.application.dao.QuestionsDao;

import java.util.LinkedList;
import java.util.Scanner;

public interface Testing {


    public LinkedList<String> getMyAnswers();

    public void setMyAnswers(LinkedList<String> myAnswers);

    public LinkedList<String> getQuestions();

    public LinkedList<String> getAnswers();

    public void setQuestions(LinkedList<String> questions);

    public void setAnswers(LinkedList<String> answers);

    // функция для ввода "языка" приложения с консоли
    //закончит выполнение только в случае корректного ввода
    public void enterLocale(Scanner scanner);

    //функция для ввода личных данных пользователя
    public void inputName(Scanner scanner);

    //функция для проверки ответа на вопрос
    public void checkingAnswers();

    public void run();

    public QuestionsDao getQuestionsDao();

    public void getScore();

    public String getName();

    public String getSurname();

}
