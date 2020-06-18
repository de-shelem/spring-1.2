package ua.khai.shelemonchak.application.repostory.inpl;

import org.springframework.stereotype.Repository;
import ua.khai.shelemonchak.application.common.Comments;
import ua.khai.shelemonchak.application.repostory.inter.CommentsRepository;

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
public class CommentsRepositoryImpl implements CommentsRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Comments findCommentsById(int id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Comments> cq = cb.createQuery(Comments.class);
        Root<Comments> commentsRoot = cq.from(Comments.class);
        Predicate idPredicate = cb.equal(commentsRoot.get("comments_id"), id);
        cq.where(idPredicate);
        TypedQuery<Comments> query = entityManager.createQuery(cq);
        return query.getResultList().get(0);
    }

    @Override
    public void save(Comments comments) {
        entityManager.persist(comments);
    }

    @Override
    public List<Comments> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Comments> cq = cb.createQuery(Comments.class);
        Root<Comments> commentsRoot = cq.from(Comments.class);
        TypedQuery<Comments> query = entityManager.createQuery(cq);
        return query.getResultList();
    }
}
