package project.dao.inmemory;

import org.springframework.stereotype.Repository;
import project.dao.UserRepository;
import project.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Repository
public class UserInMemoryRepository implements UserRepository {

    private final List<User> users = new ArrayList<>();

    @Override
    public boolean isUserWithLongExists(String login) {
        return users.stream().anyMatch(user -> user.getLogin().equals(login));
    }

    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }

    @Override
    public List<User> findAll(){
        return new ArrayList<>(users);
    }

    @Override
    public Optional<User> findUserByLogin(String login) {
        return users.stream().filter(user -> user.getLogin().equals(login)).findAny();
    }
}
