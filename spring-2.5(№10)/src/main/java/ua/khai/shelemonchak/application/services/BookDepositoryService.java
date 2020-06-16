package ua.khai.shelemonchak.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.khai.shelemonchak.application.common.*;
import ua.khai.shelemonchak.application.jpa.common.*;
import ua.khai.shelemonchak.application.repostory.*;

import java.util.List;

@Repository
public class BookDepositoryService implements BookDepository {

    private BookRepository bookRepository;
    private CommentsRepository commentsRepository;
    private GenreRepository genreRepository;
    private UserRepository userRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public BookDepositoryService(
            BookRepository bookRepository,
            CommentsRepository commentsRepository,
            GenreRepository genreRepository,
            UserRepository userRepository,
            AuthorRepository authorRepository
    ) {
        this.bookRepository = bookRepository;
        this.commentsRepository = commentsRepository;
        this.genreRepository = genreRepository;
        this.userRepository = userRepository;
        this.authorRepository = authorRepository;
    }

    public Book findBookById(int id) {
        return bookRepository.findBookById(id);
    }

    @Override
    public Author findAuthorById(int id) {
        return authorRepository.findAuthorById(id);
    }

    @Override
    public Comments findCommentsById(int id) {
        return commentsRepository.findCommentsById(id);
    }

    public void addBook(Book book) {

        bookRepository.save(book);

    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

    public void addComment(Comments comments) {
        commentsRepository.save(comments);
    }

    @Override
    public void addCommentByBookId(int id, String comment, String userName) {
        Book book = this.findBookById(id);
        if(book!=null){
            User user = this.findUserByName(userName);
            if(user == null){
                user = new User(userName);
            }
            Comments comments = new Comments(comment,user,book);
            this.addComment(comments);
            book.addComment(comments);
            this.addBook(book);
        }else{
            System.out.println("Error");
        }
    }

    public List<Comments> getAllComments() {
        return commentsRepository.findAll();
    }

    public User findUserById(int id) {
        return userRepository.findUserById(id);
    }

    public Genre findGenreById(int id) {
        return genreRepository.findGenreById(id);
    }


    public User findUserByName(String name) {
        return userRepository.findUserByName(name);
    }


    public List<User> getAllUser() {
        return userRepository.findAll();
    }


    public List<Genre> getAllGenre() {
        return genreRepository.findAll();
    }
}
