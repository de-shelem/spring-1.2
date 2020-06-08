package ua.khai.shelemonchak.application;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.khai.shelemonchak.application.dao.settings.QuestionsDaoSettingLoader;
import ua.khai.shelemonchak.application.services.testing.TestingImpl;

import java.util.Arrays;
import java.util.LinkedList;

@RunWith(SpringRunner.class)
@SpringBootTest
class ApplicationTests {

    @Autowired
    private QuestionsDaoSettingLoader settingLoader;

    @Test
    void settingLoadTest() {
        System.out.println("Start settings load test");
        Assert.assertNotEquals("", settingLoader.getFILE_NAME());
        Assert.assertNotEquals(null, settingLoader.getFILE_NAME());
        System.out.println("test passed successfully");
    }

    @Autowired
    private TestingImpl testing;

    @Test
    void checkingAnswersTest() {

        String[] trueAnswers = new String[]{"3", "6", "6", "99", "15"};
        String[] falseAnswers = new String[]{"", "", "", "", ""};

        //устанавливаем заранее верные ответы
        System.out.println("Running a test with the correct answers");
        testing.setAnswers(new LinkedList<String>(Arrays.asList(trueAnswers)));
        testing.setMyAnswers(new LinkedList<String>(Arrays.asList(trueAnswers)));
        System.out.println(testing.getAnswers());
        testing.checkingAnswers();//функция проверяет ответы
        testing.getScore();
        Assert.assertEquals(5, testing.getResult());
        //устанавливаем заранее неверные ответы
        System.out.println("Running test with incorrect answers");
        testing.setMyAnswers(new LinkedList<String>(Arrays.asList(falseAnswers)));
        testing.checkingAnswers();//функция проверяет ответы
        Assert.assertEquals(0, testing.getResult());
        System.out.println("test passed successfully");

    }

}
