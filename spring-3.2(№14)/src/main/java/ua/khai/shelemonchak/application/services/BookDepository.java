package ua.khai.shelemonchak.application.services;

import ua.khai.shelemonchak.application.entity.*;


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
    List<Comments> findAllCommentByBookId(int id);



    Book addBook (String name, String genreOfBook, String author);
    void addComment(Comments comments);
    Comments addCommentByBookId (int id, String comment,String userName);

    User findUserByName(String name);

    void deleteBookById(int id);

    void updateBookNameById(int id, String name);
}
