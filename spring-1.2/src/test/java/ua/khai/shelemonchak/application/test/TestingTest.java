package ua.khai.shelemonchak.application.test;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.khai.shelemonchak.application.services.TestingImpl;
import ua.khai.shelemonchak.application.testConfig.TestConfig;

import java.util.Arrays;
import java.util.LinkedList;

public class TestingTest {
    @Test
    //тест проверяет коректность проверки ответов пользователя
    public void checkingAnswersTest(){
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext();
        context.register(TestConfig.class);
        context.refresh();
        TestingImpl testing = context.getBean(TestingImpl.class);

        String[] trueAnswers = new String[]{"3","6","6","99","15"};
        String[] falseAnswers = new String[]{"","","","",""};



        //устанавливаем заранее верные ответы
        System.out.println("Running a test with the correct answers");
        testing.setAnswers(new LinkedList<String>(Arrays.asList(trueAnswers)));
        testing.setMyAnswers(new LinkedList<String>(Arrays.asList(trueAnswers)));
        testing.checkingAnswers();//функция проверяет ответы
        Assert.assertEquals(5,testing.getResult());
        //устанавливаем заранее неверные ответы
        System.out.println("Running test with incorrect answers");
        testing.setMyAnswers(new LinkedList<String>(Arrays.asList(falseAnswers)));
        testing.checkingAnswers();//функция проверяет ответы
        Assert.assertEquals(0,testing.getResult());

        System.out.println("End");
    }
}
