package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;
import java.util.Scanner;


public class Testing {
    private Questions myQuestions;

    public void setMyAnswers(int size) {
        this.myAnswers = new Boolean[size];
    }

    @Autowired
    private MessageSource messageSource;
    private Locale locale; //локаль, обьект создается во время выполнения
    private Boolean[] myAnswers; // результат прохождения теста
    private String surname; // фамилия пользователя
    private String name; //имя пользователя

    //конструктор
    public Testing(Questions myQuestions, MessageSource messageSource) {
        this.myQuestions = myQuestions;
        this.messageSource = messageSource;
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
    public void input(Scanner scanner) {

        System.out.println(messageSource.getMessage("your.name?", null, locale));
        name = scanner.nextLine();
        System.out.println(messageSource.getMessage("your.surname?", null, locale));
        surname = scanner.nextLine();
        System.out.println(messageSource.getMessage("hello", null, locale)
                + name + " " + surname + " " + messageSource.getMessage("start.test", null, locale));

    }

    //функция для проверки ответа на вопрос
    public void checkingAnswers(int answersNumbers, String answersStr) {
        try {


            if (answersNumbers >= 0 && answersNumbers < myQuestions.getQuestions().size())
                if (answersStr.equals(myQuestions.getAnswers().get(answersNumbers))) {
                    myAnswers[answersNumbers] = true;
                }
        } catch (Exception ex) {
            System.out.println(ex.fillInStackTrace());
        }
    }

    public void run() {// метод запускающий тест
        Scanner scanner = new Scanner(System.in);
        enterLocale(scanner);//ввод "языка"
        input(scanner);//ввод личной информации
        myAnswers = new Boolean[myQuestions.getQuestions().size()];
        for (int i = 0; i < myQuestions.getQuestions().size(); i++) {
            System.out.println(myQuestions.getQuestions().get(i));
            String str = scanner.nextLine();
            checkingAnswers(i, str);
        }
        getScore();
        System.out.println("\n" + messageSource.getMessage("end", null, locale));
    }

    public Questions getMyQuestions() {
        return myQuestions;
    }

    public void getScore() {
        System.out.println();
        for (int i = 0; i < myAnswers.length; i++) {
            System.out.println("Questions # " + (i + 1) + " - " + myAnswers[i]);
        }
    }

    public Boolean getMyAnswers(int i) {
        try {
            return myAnswers[i];
        } catch (Exception ex) {
            ex.fillInStackTrace();
        } finally {
            return myAnswers[i];
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
