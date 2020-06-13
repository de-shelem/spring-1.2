package ua.khai.shelemonchak.application.repostory;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.khai.shelemonchak.application.jpa.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("JpaQlInspection")
@Repository
@Transactional
public class BookRepositoryJpa implements BookRepository {

    @PersistenceContext
    private EntityManager em;


    public void insert(Book p) {
        em.persist(p);
    }

    public Optional<Book> getById(int id) {
        return Optional.ofNullable(em.find(Book.class, id));
    }


    public Book getFirst() {
        TypedQuery<Book> query = em.createQuery(
                "select e from Employee e where e.id = 1",
                Book.class);
        return query.getSingleResult();
    }


    public List<Book> getAll() {
        TypedQuery<Book> query = em.createQuery(
                "select e from Employee e",
                Book.class);
        return query.getResultList();
    }


    public Book getByName(String name) {
        TypedQuery<Book> query = em.createQuery(
                "select e from Employee e where e.name = :name",
                Book.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
