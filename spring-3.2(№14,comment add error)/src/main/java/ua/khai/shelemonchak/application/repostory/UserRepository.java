package ua.khai.shelemonchak.application.repostory;

import org.springframework.data.repository.CrudRepository;
import ua.khai.shelemonchak.application.common.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findUserById(int id);

    User findUserByName(String name);

    List<User> findAll ();



}
