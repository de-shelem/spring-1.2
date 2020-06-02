package application;

import TestConfig.TestConfig;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestTesting {

    @Test
    public void checkingAnswers() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(TestConfig.class);
        context.refresh();
        Testing testing = context.getBean(Testing.class);
        String[] trueAnswers = new String[]{"3", "6", "6", "99", "15"};
        testing.setMyAnswers(trueAnswers.length);
        for (int i = 0; i < trueAnswers.length; i++) {
            testing.checkingAnswers(i, trueAnswers[i]);
            Assertions.assertTrue(testing.getMyAnswers(i));
        }
    }
}
