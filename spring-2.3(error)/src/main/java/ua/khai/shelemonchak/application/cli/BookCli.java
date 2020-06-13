package ua.khai.shelemonchak.application.cli;

import org.h2.tools.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ua.khai.shelemonchak.application.jpa.Book;

import ua.khai.shelemonchak.application.repostory.BookRepository;

import java.sql.SQLException;
import java.util.List;


@ShellComponent
public class BookCli {
    @Autowired
    public BookCli(BookRepository bookDao) {
        this.bookDao = bookDao;
    }

    private BookRepository bookDao;

    @ShellMethod(value = "Insert a new row into the database", key = "insert")
    public void insert(
            @ShellOption(help = "name")String name,
            @ShellOption(help = "author")String author,
            @ShellOption(help = "genre")String genre
    )
    {
        bookDao.insert(new Book(name, author, genre));
    }

    @ShellMethod(value = "Get book by id", key = "getById")
    public void getById(int id) {
        System.out.println(bookDao.getById(id));
    }

    @ShellMethod(value = "Show full list", key = "getAll")
    public void getAll() {
        System.out.println(bookDao.getAll());
    }

    @ShellMethod(value = "Get by name", key = "getByName")
    public void getByName(String string) {
        System.out.println(bookDao.getByName(string));
    }

    @ShellMethod(value = "?", key = "getFirst")
    public void getFirst(String string) {
        System.out.println(bookDao.getFirst());
    }

    @ShellMethod(value = "Open web interface", key = "web")
    public void web() throws SQLException {
        Console.main();
    }

}
