package ua.khai.shelemonchak.application.services.testing;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import ua.khai.shelemonchak.application.dao.QuestionsDao;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

@EnableAspectJAutoProxy
@Service
public class TestingImpl implements Testing {


    private QuestionsDao questionsDao;
    private MessageSource messageSource;
    private Locale locale; //локаль, обьект создается во время выполнения
    private LinkedList<String> myAnswers; // результат прохождения теста
    private String surname; // фамилия пользователя
    private String name; //имя пользователя
    private boolean testIsComp = false;

    private int result;

    //конструктор
    @Autowired
    public TestingImpl(QuestionsDao questionsDao, MessageSource messageSource) {

        this.questionsDao = questionsDao;
        this.messageSource = messageSource;

    }

    //функция для ввода личных данных пользователя
    public void inputName(Scanner scanner) {

        System.out.println(messageSource.getMessage("your.name?", null, locale));
        name = scanner.nextLine();
        System.out.println(messageSource.getMessage("your.surname?", null, locale));
        surname = scanner.nextLine();
        System.out.println(messageSource.getMessage("hello", null, locale)
                + name + " " + surname + " " + messageSource.getMessage("start.test", null, locale));

    }

    //функция для проверки ответа на вопрос
    public void checkingAnswers() {
        result = 0;
        Iterator myAnswersIter = myAnswers.iterator();
        Iterator AnswersIter = getAnswers().iterator();
        for (; myAnswersIter.hasNext() && AnswersIter.hasNext(); ) {
            result += myAnswersIter.next().equals(AnswersIter.next()) ? 1 : 0;
        }
    }

    public void run() {// метод запускающий тест
        if (!testIsComp) {
            Scanner scanner = new Scanner(System.in);
            if (locale == null) {
                setLocale(new Locale("en", "EN"));
            }
            inputName(scanner);//ввод личной информации
            Iterator myQuestionsIterator = getQuestions().iterator();
            myAnswers = new LinkedList<String>();
            for (; myQuestionsIterator.hasNext(); ) {
                System.out.println(myQuestionsIterator.next());
                myAnswers.add(scanner.nextLine());
            }
            checkingAnswers();
            testIsComp = true;
            System.out.println("\n" + messageSource.getMessage("end", null, locale));
        } else {
            System.out.println("Test already passed");
        }
    }

    public void getScore() {
        if (testIsComp) {
            System.out.println();
            Iterator myAnswersIter = myAnswers.iterator();
            Iterator AnswersIter = questionsDao.getAnswers().iterator();
            int i = 0;
            for (; myAnswersIter.hasNext(); )
                System.out.println("Questions # " + (++i) + " - " + (myAnswersIter.next().equals(AnswersIter.next()) ? 1 : 0));
            System.out.println("Your result is " + result);
        } else {
            System.out.println("Error. Test not yet passed");
        }

    }

    public void clean() {
        testIsComp = false;
        myAnswers = new LinkedList<String>();
    }

    public void setMyAnswers(LinkedList<String> myAnswers) {
        this.myAnswers = myAnswers;
    }

    public LinkedList<String> getQuestions() {
        return questionsDao.getQuestions();
    }

    public LinkedList<String> getAnswers() {
        return questionsDao.getAnswers();
    }

    public void setAnswers(LinkedList<String> answers) {
        this.questionsDao.setAnswers(answers);
    }

    public int getResult() {
        return result;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
