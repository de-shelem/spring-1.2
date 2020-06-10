package ua.khai.shelemonchak.application.dao;

import ua.khai.shelemonchak.application.domain.Book;

import java.util.List;

public interface BookDao {

    int count();

    void insert(Book book);

    Book getById(int id);

    List<Book> getAll();

    void deleteById(int id);



}
