package ua.khai.shelemonchak.application.cli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ua.khai.shelemonchak.application.common.*;
import ua.khai.shelemonchak.application.services.BookDepository;

import java.util.HashSet;
import java.util.Iterator;

@ShellComponent
public class BookDepositoryCli {

    BookDepository bookDepository;

    @Autowired
    public BookDepositoryCli(BookDepository bookDepository) {
        this.bookDepository = bookDepository;
    }

    @ShellMethod(value = "Insert a new book(name, author, genre)", key = "insert")
    public void addBook(String name, String author, String genre
    ) {
        String[] authorStrArr = author.split(",");
        HashSet<Author> authorHashSet = new HashSet<Author>();
        for (int i = 0; i < authorStrArr.length; i++)
            authorHashSet.add(new Author(authorStrArr[i]));


        bookDepository.addBook(new Book(name, new Genre(genre), authorHashSet));
    }

    @ShellMethod(value = "get all books", key = "get-all-books")
    public void getAllBooks() {
        Iterator<Book> bookIterator = bookDepository.getAllBooks().listIterator();
        System.out.println();
        for (; bookIterator.hasNext(); ) {

            System.out.println(bookIterator.next());
        }
        System.out.println();
    }

    @ShellMethod(value = "get all author", key = "get-all-authors")
    public void getAllAuthor() {
        Iterator<Author> authorIterator = bookDepository.getAllAuthor().listIterator();
        System.out.println();
        for (; authorIterator.hasNext(); ) {
            System.out.println(authorIterator.next());
        }
        System.out.println();
    }

    @ShellMethod(value = "get all comments", key = "get-all-comments")
    public void getAllComments() {
        Iterator<Comments> commentsIterator = bookDepository.getAllComments().listIterator();
        System.out.println();
        for (; commentsIterator.hasNext(); ) {
            System.out.println(commentsIterator.next());
        }
        System.out.println();
    }

    @ShellMethod(value = "get all genre", key = "get-all-genre")
    public void getAllGenre() {
        Iterator<Genre> genreIterator = bookDepository.getAllGenre().listIterator();
        System.out.println();
        for (; genreIterator.hasNext(); ) {

            System.out.println(genreIterator.next());
        }
        System.out.println();
    }

    @ShellMethod(value = "get all user", key = "get-all-user")
    public void getAllUser() {
        Iterator<User> userIterator = bookDepository.getAllUser().listIterator();
        System.out.println();
        for (; userIterator.hasNext(); ) {
            System.out.println(userIterator.next());
        }
        System.out.println();
    }


    @ShellMethod(value = "get books by id", key = "get-books-id")
    public void getBooksById(int id) {
        System.out.println(bookDepository.findBookById(id));
    }

    @ShellMethod(value = "get author by id", key = "get-authors-id")
    public void getAuthorById(int id) {
        System.out.println(bookDepository.findAuthorById(id));
    }

    @ShellMethod(value = "get comments by id", key = "get-comments-id")
    public void getCommentsById(int id) {
        System.out.println(bookDepository.findCommentsById(id));
    }

    @ShellMethod(value = "get genre by id", key = "get-genre-id")
    public void getGenreById(int id) {
        System.out.println(bookDepository.findGenreById(id));
    }

    @ShellMethod(value = "get user by id", key = "get-user-id")
    public void getUserById(int id) {
        System.out.println(bookDepository.findUserById(id));
    }

    @ShellMethod(value = "Insert a new commentary for book(id of book,comment text, yor username)", key = "insert-comment")
    public void addCommentByBookId(int id, String comment, String userName) {
        bookDepository.addCommentByBookId(id, comment, userName);

    }

}
