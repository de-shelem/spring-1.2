package ua.khai.shelemonchak.application.repostory;

import org.springframework.data.repository.CrudRepository;
import ua.khai.shelemonchak.application.common.Book;
import ua.khai.shelemonchak.application.common.Comments;

import java.util.List;


public interface CommentsRepository extends CrudRepository<Comments, Integer> {

    Comments findCommentsById(int id);

    List<Comments> findAllByBook(Book book);

    List<Comments> findAll();


}
