package ua.khai.shelemonchak.application.repostory.inpl;


import org.springframework.stereotype.Repository;
import ua.khai.shelemonchak.application.common.Book;
import ua.khai.shelemonchak.application.repostory.inter.BookRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookRepositoryImpl implements BookRepository {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void update(Book book) {
        entityManager.refresh(book);
    }

    @Override
    public void save(Book book) {
        entityManager.persist(book);
    }

    @Override
    public Book findBookById(int id) {
        try {

            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Book> cq = cb.createQuery(Book.class);
            Root<Book> bookRoot = cq.from(Book.class);
            Predicate idPredicate = cb.equal(bookRoot.get("id"), id);
            cq.where(idPredicate);
            TypedQuery<Book> query = entityManager.createQuery(cq);
            return query.getResultList().get(0);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Book> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> bookRoot = cq.from(Book.class);
        TypedQuery<Book> query = entityManager.createQuery(cq);
        return query.getResultList();
    }

}
