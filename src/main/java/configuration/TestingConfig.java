package configuration;

import application.Questions;
import application.Testing;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class TestingConfig extends MessageConfig {
    @Bean
    public Questions questions() throws IOException {
        return new Questions();
    }

    @Bean
    public Testing tests(Questions questions, MessageSource messageSource) {
        return new Testing(questions, messageSource);
    }
}
