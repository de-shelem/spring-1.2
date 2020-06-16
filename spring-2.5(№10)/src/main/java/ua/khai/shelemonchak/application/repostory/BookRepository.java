package ua.khai.shelemonchak.application.repostory;

import org.springframework.data.repository.CrudRepository;
import ua.khai.shelemonchak.application.common.Book;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
public interface BookRepository extends CrudRepository<Book,Integer> {

    Book findBookById(int id);
    List<Book> findAll();


}
