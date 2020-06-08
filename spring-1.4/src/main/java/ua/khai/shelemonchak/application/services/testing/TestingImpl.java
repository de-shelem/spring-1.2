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


    private int result;

    //конструктор
    @Autowired
    public TestingImpl(QuestionsDao questionsDao, MessageSource messageSource) {

        this.questionsDao = questionsDao;
        this.messageSource = messageSource;

    }

    public LinkedList<String> getMyAnswers() {
        return myAnswers;
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

    public void setQuestions(LinkedList<String> questions) {
        this.questionsDao.setQuestions(questions);
    }

    public void setAnswers(LinkedList<String> answers) {
        this.questionsDao.setAnswers(answers);
    }

    // функция для ввода "языка" приложения с консоли
    //закончит выполнение только в случае корректного ввода
    public void enterLocale(Scanner scanner) {
        while (true) {
            String str;
            try {
                System.out.println("Enter yor language \n en/ru");
                str = scanner.nextLine();
                if (!str.equals("en") & !str.equals("ru")) {
                    throw new Exception();
                }
                locale = new Locale(str, str.toUpperCase());
                break;
            } catch (Exception e) {
                System.out.println("incorrect!");
            }
        }
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
        result =0;
        Iterator myAnswersIter = myAnswers.iterator();
        Iterator AnswersIter = getAnswers().iterator();
        for (; myAnswersIter.hasNext() && AnswersIter.hasNext(); ) {
            result += myAnswersIter.next().equals(AnswersIter.next()) ? 1 : 0;
        }
    }

    public void run() {// метод запускающий тест
        Scanner scanner = new Scanner(System.in);
        enterLocale(scanner);//ввод "языка"
        inputName(scanner);//ввод личной информации
        Iterator myQuestionsIterator = getQuestions().iterator();
        myAnswers = new LinkedList<String>();
        for (; myQuestionsIterator.hasNext(); ) {
            System.out.println(myQuestionsIterator.next());
            myAnswers.add(scanner.nextLine());
        }
        checkingAnswers();
        getScore();
        System.out.println("\n" + messageSource.getMessage("end", null, locale));
    }

    public QuestionsDao getQuestionsDao() {
        return questionsDao;
    }

    public void getScore() {
        System.out.println();
        Iterator myAnswersIter = myAnswers.iterator();
        Iterator AnswersIter = questionsDao.getAnswers().iterator();
        int i = 0;
        for (; myAnswersIter.hasNext(); )
            System.out.println("Questions # " + (++i) + " - " + (myAnswersIter.next().equals(AnswersIter.next()) ? 1 : 0));
        System.out.println("Your result is " + result);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getResult() {
        return result;
    }
}
