package project.dao;

import project.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    boolean isUserWithLongExists(String login);

    User save(User user);

    List<User> findAll ();

    Optional<User> findUserByLogin(String login);

}
