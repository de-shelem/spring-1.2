package ua.khai.shelemonchak.application.services;

import ua.khai.shelemonchak.application.common.*;
import ua.khai.shelemonchak.application.jpa.common.*;

import java.util.List;

public interface BookDepository   {

    List<User> getAllUser ();
    List<Genre> getAllGenre();
    List<Book> getAllBooks();
    List<Author> getAllAuthor();
    List<Comments> getAllComments();

    User findUserById(int id);
    Genre findGenreById(int id);
    Book findBookById(int id);
    Author findAuthorById(int id);
    Comments findCommentsById(int id);

    void addBook (Book book);
    void addComment(Comments comments);
    void addCommentByBookId (int id, String comment,String userName);

    User findUserByName(String name);



}
