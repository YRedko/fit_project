package project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import project.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsUserByLogin(String login);

    Optional<User> findUserByLogin(String login);

//    boolean isUserWithLongExists(String login);
//
//    User save(User user);
//
//    List<User> findAll ();
//
//    Optional<User> findUserByLogin(String login);

}
