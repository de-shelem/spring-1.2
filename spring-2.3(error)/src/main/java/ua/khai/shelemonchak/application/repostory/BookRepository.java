package ua.khai.shelemonchak.application.repostory;

import ua.khai.shelemonchak.application.jpa.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    void insert(Book p);

    Optional<Book> getById(int id);

    Book getFirst();

    List<Book> getAll();

    Book getByName(String name);
}
