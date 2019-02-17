package dao.inmemory;

import dao.UserRepository;
import domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Optional<User> findUserByLogin(String login) {
        return users.stream().filter(user -> user.getLogin().equals(login)).findAny();
    }
}
