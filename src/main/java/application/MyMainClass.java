package application;

import configuration.TestingConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyMainClass {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(TestingConfig.class);

        context.refresh();
        Testing test = context.getBean(Testing.class);
        test.run();

    }
}
