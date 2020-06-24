package ua.khai.shelemonchak.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.khai.shelemonchak.application.entity.*;
import ua.khai.shelemonchak.application.repostory.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
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

    @Override
    public List<Comments> findAllCommentByBookId(int id) {
        Book book = bookRepository.findBookById(id);
        if (book != null) {
            return commentsRepository.findAllByBook(book);
        } else {
            return new ArrayList<Comments>();
        }
    }

    public Book addBook(String name, String genreOfBook, String author) {
        Genre genre = genreRepository.findGenreByNameOfGenre(genreOfBook);
        if (genre == null) {
            genre = new Genre(genreOfBook);
        }
        String[] authorsStrArr = author.split(",");
        Set<Author> authorSet = new HashSet<Author>();
        for (int i = 0; i < authorsStrArr.length; i++) {
            Author author1 = authorRepository.findAuthorByName(authorsStrArr[i]);
            if (author1 == null)
                author1 = new Author(authorsStrArr[i]);
            authorSet.add(author1);

        }

        Book book = new Book(name, genre,authorSet);
        return bookRepository.save(book);

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

    public Comments addCommentByBookId(int id, String comment, String userName) {
        Book book = this.findBookById(id);
        if (book != null) {
            User user = this.findUserByName(userName);
            if (user == null) {
                user = new User(userName);
            }
            Comments comments = new Comments(comment, user, book);
            this.addComment(comments);
            book.addComment(comments);
            this.bookRepository.save(book);
            return comments;
        } else {
            System.out.println("Error");
            return new Comments();
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

    @Override
    public void deleteBookById(int id) {
        bookRepository.deleteBookById(id);
    }

    @Override
    public void updateBookNameById(int id, String name) {
        Book book = bookRepository.findBookById(id);
        book.setName (name);
        bookRepository.save(book);
    }


    public List<User> getAllUser() {
        return userRepository.findAll();
    }


    public List<Genre> getAllGenre() {
        return genreRepository.findAll();
    }
}
