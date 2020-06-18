package ua.khai.shelemonchak.application.repostory.inpl;

import org.springframework.stereotype.Repository;
import ua.khai.shelemonchak.application.common.Author;
import ua.khai.shelemonchak.application.repostory.inter.AuthorRepository;

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
public class AuthorRepositoryImpl implements AuthorRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Author author) {
        entityManager.persist(author);
    }

    @Override
    public Author findAuthorById(int id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Author> cq = cb.createQuery(Author.class);
        Root<Author> authorRoot = cq.from(Author.class);
        Predicate idPredicate = cb.equal(authorRoot.get("author_id"), id);
        cq.where(idPredicate);
        TypedQuery<Author> query = entityManager.createQuery(cq);
        return query.getResultList().get(0);
    }

    @Override
    public List<Author> findAll() {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Author> cq = cb.createQuery(Author.class);
        Root<Author> authorRoot = cq.from(Author.class);
        TypedQuery<Author> query = entityManager.createQuery(cq);
        return query.getResultList();
    }
}
