package project.dao.jdbc;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import project.dao.UserRepository;
import project.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class JdbcUserRepository implements UserRepository {

    private final ConnectionManager connectionManager;

    @Override
    @SneakyThrows
    public boolean isUserWithLongExists(String login) {
        try (Connection connection = connectionManager.createConnection()) {
            connection.setAutoCommit(false);
            try {
                PreparedStatement userStatement = connection.prepareStatement("SELECT * FROM owner WHERE login=?");
                userStatement.setString(1, login);
                ResultSet userResultSet = userStatement.executeQuery();
                while (userResultSet.next()) {
                    String userLogin = userResultSet.getString("login");
                    if (userLogin.equals(login)) {
                        return true;
                    }
                }
            } catch (Exception e) {
                log.error("Is user already exist error! {}", e);
                connection.rollback();
                throw e;
            }
            return false;
        }
    }

    @Override
    @SneakyThrows
    public User save(User user) {
        try(Connection connection = connectionManager.createConnection()){
            connection.setAutoCommit(false);
            try {
                if (!isUserWithLongExists(user.getLogin())) {
                    String sql = "INSERT into owner (login, password_hash) values (?, ?)";
                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
                        statement.setString(1, user.getLogin());
                        statement.setString(2, user.getPasswordHash());
                        statement.executeUpdate();
                    }
                } else {
                    try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE owner SET password_hash=? WHERE login=?")) {
                        preparedStatement.setString(1, user.getLogin());
                        preparedStatement.setString(2, user.getPasswordHash());
                        preparedStatement.executeUpdate();
                    }
                }
                connection.commit();
            } catch (Exception e) {
                log.error("Error saving user {}", e);
                connection.rollback();
                throw e;
            }
        }
        return user;
    }

    @Override
    @SneakyThrows
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try(Connection connection = connectionManager.createConnection()) {
            PreparedStatement userStatement = connection.prepareStatement("SELECT * FROM owner");
            ResultSet userResultSet = userStatement.executeQuery();
            while (userResultSet.next()){
                User user = new User();
                user.setLogin(userResultSet.getString("user.login"));
                user.setPasswordHash(userResultSet.getString("user.password_hash"));
                users.add(user);
            }
        }
        return users;
    }

    @Override
    @SneakyThrows
    public Optional<User> findUserByLogin(String login) {
        User user = new User();
        try(Connection connection = connectionManager.createConnection()){
            connection.setAutoCommit(false);
            try {
                try (PreparedStatement statement = connection.prepareStatement("SELECT * from owner WHERE login=?")) {
                    statement.setString(1, login);
                    try(ResultSet set = statement.executeQuery()){
                        while (set.next()) {
                            String userLogin = set.getString("login");
                            String passwordHash = set.getString("password_hash");
                            user = new User(userLogin, passwordHash);
                        }
                    }
                }
                connection.commit();
            } catch (Exception e) {
                log.error("Error finding user {}", e);
                connection.rollback();
                throw e;
            }
        }
        return Optional.of(user);
    }
}
