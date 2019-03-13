package project.dao.inmemory;

import org.junit.Test;
import project.domain.User;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class UserInMemoryRepositoryTest {

    private UserInMemoryRepository repository = new UserInMemoryRepository();

    @Test
    public void isUserWithLongExists() {
        List<User> users = asList(new User("lg1", "p1"), new User("lg1", "p2"));
        users.forEach(repository::save);
        assertTrue(repository.isUserWithLongExists("lg1"));
        assertFalse(repository.isUserWithLongExists("lg3"));
    }

    @Test
    public void save() {
        List<User> users = asList(new User("lg1", "p1"), new User("lg1", "p2"));
        users.forEach(repository::save);
        assertEquals(users, repository.findAll());
    }

    @Test
    public void findUserByLogin() {
        List<User> users = asList(new User("lg1", "p1"), new User("lg1", "p2"));
        users.forEach(repository::save);
        assertEquals(Optional.of(new User("lg1", "p1")), repository.findUserByLogin("lg1"));
        assertEquals(Optional.empty(), repository.findUserByLogin("lg3"));
    }
}