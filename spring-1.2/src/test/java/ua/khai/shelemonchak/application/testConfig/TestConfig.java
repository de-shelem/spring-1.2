package ua.khai.shelemonchak.application.testConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ua.khai.shelemonchak.application.configuration.MessageConfig;
import ua.khai.shelemonchak.application.dao.QuestionsDao;
import ua.khai.shelemonchak.application.dao.QuestionsDaoCvs;
import ua.khai.shelemonchak.application.services.TestingImpl;

import java.io.IOException;
@PropertySource("classpath:application.properties")
@Configuration
public class TestConfig extends MessageConfig {
    @Bean
    public QuestionsDao questions(@Value("${cvs.file.name}") String cvsFileName) throws IOException {
        return new QuestionsDaoCvs(cvsFileName);
    }

    @Bean
    public TestingImpl tests(QuestionsDao questions, MessageSource messageSource) {
        return new TestingImpl(questions, messageSource);
    }

}
