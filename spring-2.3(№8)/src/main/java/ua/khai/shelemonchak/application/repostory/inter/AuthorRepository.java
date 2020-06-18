package ua.khai.shelemonchak.application.repostory.inter;

import ua.khai.shelemonchak.application.common.Author;

import java.util.List;

public interface AuthorRepository {

    void save(Author author);

    Author findAuthorById(int id);

    List<Author> findAll();

}
