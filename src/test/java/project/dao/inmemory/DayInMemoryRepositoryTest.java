package project.dao.inmemory;

import org.junit.Test;
import project.domain.Day;
import project.domain.Food;
import project.domain.FoodConsumption;
import project.domain.User;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class DayInMemoryRepositoryTest {

    private DayInMemoryRepository repository = new DayInMemoryRepository();

    @Test
    public void save() {
        FoodConsumption foodList = new FoodConsumption(1L, asList(new Food(foodDto.getName(), foodDto.getCalories(), foodDto.getProtein(), foodDto.getFat(), foodDto.getCarbs())));
        List<Day> days = asList(
                new Day(Instant.ofEpochSecond(3600), "New", new User(), 1000L, foodList),
                new Day(Instant.ofEpochSecond(7200), "New", new User(), 2000L, foodList)
        );
        days.forEach(repository::save);
        assertEquals(days, repository.findAll());
    }

//    @Test
//    public void update() {
//    }

    @Test
    public void findDayByFoodAndUser() {
    }

    @Test
    public void findDayByUser() {
    }

    @Test
    public void findDayByDate() {
        User user = new User();
        List<FoodConsumption> food = new ArrayList<>();
        List<Day> days = asList(
                new Day("2019.04.01", user, food),
                new Day("2019.04.02", user, food),
                new Day("2019.04.03", user, food)
        );
        Day day = new Day("2019.04.01", user, food);
        days.forEach(repository::save);
        assertEquals(day, repository.findDayByDate("2019.04.01"));
    }
}