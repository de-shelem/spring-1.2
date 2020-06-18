package ua.khai.shelemonchak.application.repostory.inpl;

import org.springframework.stereotype.Repository;
import ua.khai.shelemonchak.application.common.User;
import ua.khai.shelemonchak.application.repostory.inter.UserRepository;

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
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findUserById(int id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> userRoot = cq.from(User.class);
        Predicate idPredicate = cb.equal(userRoot.get("user_id"), id);
        cq.where(idPredicate);
        TypedQuery<User> query = entityManager.createQuery(cq);
        return query.getResultList().get(0);
    }

    @Override
    public User findUserByName(String name) {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<User> cq = cb.createQuery(User.class);
            Root<User> userRoot = cq.from(User.class);
            Predicate idPredicate = cb.equal(userRoot.get("name"), name);
            cq.where(idPredicate);
            TypedQuery<User> query = entityManager.createQuery(cq);
            return query.getResultList().get(0);
        }catch (Exception e){
           return  null;
        }
    }

    @Override
    public List<User> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> userRoot = cq.from(User.class);
        TypedQuery<User> query = entityManager.createQuery(cq);
        return query.getResultList();
    }
}
