package ua.khai.shelemonchak.application.services.testing;

import ua.khai.shelemonchak.application.dao.QuestionsDao;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

public interface Testing {

    //функция для ввода личных данных пользователя
    void inputName(Scanner scanner);

    //функция для проверки ответа на вопрос
    void checkingAnswers();

    void run();

    void getScore();

    void setLocale(Locale locale) ;

    public void clean();
}
