package ua.khai.shelemonchak.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import ua.khai.shelemonchak.application.dao.settings.QuestionsDaoSetting;
import ua.khai.shelemonchak.application.services.testing.TestingImpl;

@EnableAspectJAutoProxy
@SpringBootApplication
@Component
@ComponentScan(basePackages = "ua.khai.shelemonchak")
@EnableConfigurationProperties(QuestionsDaoSetting.class)
public class Application {


    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class);
        TestingImpl testing = context.getBean(TestingImpl.class);
        testing.run();
    }


}






