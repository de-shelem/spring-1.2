package ua.khai.shelemonchak.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.khai.shelemonchak.application.services.BookDepository;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {
    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    BookDepository bookDepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void init() {
        bookDepository.addBook("11/22/63", "fantastic", "St.king");
        bookDepository.addCommentByBookId(1, "comment number 1", "username");
    }
}
