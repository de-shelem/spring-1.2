package ua.khai.shelemonchak.application.cli;

import org.h2.tools.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ua.khai.shelemonchak.application.dao.BookDao;
import ua.khai.shelemonchak.application.domain.Book;

import java.sql.SQLException;
import java.util.List;

@ShellComponent
public class BookCli {
    @Autowired
    public BookCli(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    private BookDao bookDao;

    @ShellMethod(value = "Insert a new row into the database", key = "insert")
    public void insert(
            @ShellOption(help = "id")int id,
            @ShellOption(help = "name")String name,
            @ShellOption(help = "author")String author,
            @ShellOption(help = "genre")String genre
    ) {
        bookDao.insert(new Book(id, name, author, genre));
    }

    @ShellMethod(value = "Delete book by id", key = "deleteById")
    public void deleteById(int id) {
        bookDao.deleteById(id);
    }

    @ShellMethod(value = "Count", key = "count")
    public void count() {
        System.out.println(bookDao.count());
    }


    @ShellMethod(value = "Get book by id", key = "getById")
    public void getById(int id) {
        System.out.println(bookDao.getById(id));
    }

    @ShellMethod(value = "Show full list", key = "getAll")
    public void getAll() {
        System.out.println(bookDao.getAll());
    }

    @ShellMethod(value = "Open web interface", key = "web")
    public void web() throws SQLException {
        Console.main();

    }

}
