package ua.khai.shelemonchak.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.stereotype.Component;
import ua.khai.shelemonchak.application.dao.settings.QuestionsDaoSetting;


@SpringBootApplication
@Component
@ComponentScan(basePackages = "ua.khai.shelemonchak")
@EnableConfigurationProperties(QuestionsDaoSetting.class)
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class);

    }


}






