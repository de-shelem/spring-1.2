package ua.khai.shelemonchak.application.repostory.inter;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.khai.shelemonchak.application.common.User;

import java.util.List;

public interface UserRepository {

    void save(User user);

    User findUserById(int id);

    User findUserByName(String name);

    List<User> findAll();


}
