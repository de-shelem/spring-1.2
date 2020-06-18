package ua.khai.shelemonchak.application.repostory.inter;

import ua.khai.shelemonchak.application.common.Book;

import java.util.List;


public interface BookRepository {

    void update(Book book );

    void save(Book book);

    Book findBookById(int id);

    List<Book> findAll();


}
