package ua.khai.shelemonchak.application.cli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ua.khai.shelemonchak.application.services.testing.Testing;


import java.util.Locale;

@ShellComponent
public class TestingCli {

    private Testing testing;

    @Autowired
    public TestingCli(Testing testing) {

        this.testing = testing;
    }

    @ShellMethod(value = "Run testing students ", key = "run")
    public void runTesting() {
        testing.run();
    }

    @ShellMethod(value = "Select your language, enter \"en\" or \"ru\" ", key = "lang")
    public void setLocale(@ShellOption(help = "locale") String locale) {
        if (locale.equals("en") || locale.equals("ru")) {
            testing.setLocale(new Locale(locale, locale.toUpperCase()));
        } else {
            System.out.println("Input error. Enter \"en\" or \"ru\"");
        }
    }

    @ShellMethod(value = "Show your result ", key = "showres")
    public void getResult() {
        testing.getScore();
    }

    @ShellMethod(value = "Clean your test", key = "clean")
    public void clean() {
        testing.clean();
    }

}
