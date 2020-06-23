package ua.khai.shelemonchak.application.repostory;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ua.khai.shelemonchak.application.common.Book;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
public interface BookRepository extends CrudRepository<Book,Integer> {

    Book findBookById(int id);
    List<Book> findAll();
    void deleteBookById(int id);


}
