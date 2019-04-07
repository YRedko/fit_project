package project.dao.inmemory;

import org.junit.Test;
import project.domain.Day;
import project.domain.Food;
import project.domain.FoodConsumption;
import project.domain.User;

import java.time.Instant;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class DayInMemoryRepositoryTest {

    private DayInMemoryRepository repository = new DayInMemoryRepository();

    @Test
    public void save() {
        FoodConsumption foodList = new FoodConsumption(1L, asList(new Food()));
        List<Day> days = asList(
                new Day(Instant.ofEpochSecond(3600), "New", new User(), 1000L, foodList),
                new Day(Instant.ofEpochSecond(7200), "New", new User(), 2000L, foodList)
        );
        days.forEach(repository::save);
        assertEquals(days, repository.findAll());
    }

    @Test
    public void update() {
    }

    @Test
    public void findDayByFoodAndUser() {
    }

    @Test
    public void findDayByUser() {
    }

    @Test
    public void findById() {
    }
}