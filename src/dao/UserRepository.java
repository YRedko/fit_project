package dao;

import domain.User;
import java.util.Optional;

public interface UserRepository {

    boolean isUserWithLongExists(String login);

    User save(User user);

    Optional<User> findUserByLogin(String login);

}
