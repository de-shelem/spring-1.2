package ua.khai.shelemonchak.application.repostory.inpl;

import org.springframework.stereotype.Repository;
import ua.khai.shelemonchak.application.common.Genre;
import ua.khai.shelemonchak.application.repostory.inter.GenreRepository;

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
public class GenreRepositoryImpl implements GenreRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Genre findGenreById(int id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Genre> cq = cb.createQuery(Genre.class);
        Root<Genre> genreRoot = cq.from(Genre.class);
        Predicate idPredicate = cb.equal(genreRoot.get("genre_id"), id);
        cq.where(idPredicate);
        TypedQuery<Genre> query = entityManager.createQuery(cq);
        return query.getResultList().get(0);
    }

    @Override
    public void save(Genre genre) {
        entityManager.persist(genre);
    }

    @Override
    public List<Genre> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Genre> cq = cb.createQuery(Genre.class);
        Root<Genre> genreRoot = cq.from(Genre.class);
        TypedQuery<Genre> query = entityManager.createQuery(cq);
        return query.getResultList();
    }
}
