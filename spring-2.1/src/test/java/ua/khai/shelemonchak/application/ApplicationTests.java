package ua.khai.shelemonchak.application;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.test.context.junit4.SpringRunner;
import ua.khai.shelemonchak.application.dao.BookDao;
import ua.khai.shelemonchak.application.domain.Book;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false"
})
class ApplicationTests {


    @Autowired
    private BookDao bookDao;
    private final int SIZE = 5;
    Book[] books = new Book[SIZE];

    @Test
    void countTest(){
        books[0] = new Book(1, "one", "authorOne", "genreOne");
        books[1] = new Book(2, "two", "authorTwo", "genreTwo");
        books[2] = new Book(3, "three", "authorThree", "genreThree");
        books[3] = new Book(4, "four", "authorFour", "genreFour");
        books[4] = new Book(5, "five", "authorFive", "genreFive");


        for (int i = 0; i < SIZE; i++) {

            bookDao.insert(books[i]);
        }

        Assert.assertEquals(SIZE,bookDao.count());
        for (int i = 1; i <= SIZE; i++) {

            bookDao.deleteById(i);
        }
    }

    @Test
    void getByIdTest(){
        books[0] = new Book(1, "one", "authorOne", "genreOne");
        books[1] = new Book(2, "two", "authorTwo", "genreTwo");
        books[2] = new Book(3, "three", "authorThree", "genreThree");
        books[3] = new Book(4, "four", "authorFour", "genreFour");
        books[4] = new Book(5, "five", "authorFive", "genreFive");


        for (int i = 0; i < SIZE; i++) {

            bookDao.insert(books[i]);
        }

        for (int i = 0; i < SIZE; i++) {

            Assert.assertEquals(books[i].toString(), bookDao.getById(i+1).toString());
        }
        for (int i = 1; i <= SIZE; i++) {

            bookDao.deleteById(i);
        }

    }
    @Test
    void insertDeleteTest() {

        books[0] = new Book(1, "one", "authorOne", "genreOne");
        books[1] = new Book(2, "two", "authorTwo", "genreTwo");
        books[2] = new Book(3, "three", "authorThree", "genreThree");
        books[3] = new Book(4, "four", "authorFour", "genreFour");
        books[4] = new Book(5, "five", "authorFive", "genreFive");


        for (int i = 0; i < SIZE; i++) {

            bookDao.insert(books[i]);
        }
        System.out.println(bookDao.getAll());
        for (int i = 0; i < SIZE; i++) {

            Assert.assertEquals(books[i].toString(), bookDao.getById(i+1).toString());
        }
        for (int i = 1; i <= SIZE; i++) {

        	bookDao.deleteById(i);
        }
		for (int i = 0; i < SIZE; i++) {

			Assert.assertEquals(null, bookDao.getById(i+1));
		}
    }

    @Test
    void getAllTest(){

        books[0] = new Book(1, "one", "authorOne", "genreOne");
        books[1] = new Book(2, "two", "authorTwo", "genreTwo");
        books[2] = new Book(3, "three", "authorThree", "genreThree");
        books[3] = new Book(4, "four", "authorFour", "genreFour");
        books[4] = new Book(5, "five", "authorFive", "genreFive");


        for (int i = 0; i < SIZE; i++) {

            bookDao.insert(books[i]);
        }

        List<Book> listBook = bookDao.getAll();
        for (int i = 0; i <SIZE ; i++) {

            Assert.assertEquals(books[i].toString(),listBook.get(i).toString());

        }
        for (int i = 1; i <= SIZE; i++) {

            bookDao.deleteById(i);
        }

    }

}
