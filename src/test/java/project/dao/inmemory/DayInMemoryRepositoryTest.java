/*
package project.dao.inmemory;

import org.junit.Test;
import project.domain.Day;
import project.domain.Food;
import project.domain.FoodConsumption;
import project.domain.User;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class DayInMemoryRepositoryTest {

    private DayInMemoryRepository repository = new DayInMemoryRepository();

    @Test
    public void save() {
        Food food = new Food("bread", 1L, 1L, 1L, 1L);
        List<FoodConsumption> foodList = asList(new FoodConsumption(food, 10L, new Day()));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate1 = LocalDate.parse("2019-04-01", formatter);
        LocalDate localDate2 = LocalDate.parse("2019-04-02", formatter);
        List<Day> days = asList(
                new Day(localDate1, new User(), foodList),
                new Day(localDate2, new User(), foodList)
        );
        days.forEach(repository::save);
        assertEquals(days, repository.findAll());
    }

//    @Test
//    public void update() {
//    }

    @Test
    public void findDayByFoodAndUser() {
        User user1 = new User("1", "1");
        User user2 = new User("2", "2");
        Food foodBread = new Food("bread", 25L, 1L, 1L, 16L);
        Food foodMeat = new Food("meet", 57L, 18L, 4L, 5L);
        Food foodMushrooms = new Food("mushrooms", 18L, 2L, 1L, 8L);
        Food foodEgg = new Food("egg", 21L, 9L, 1L, 4L);
        List<FoodConsumption> foodConsumptions1 = asList(
                new FoodConsumption(foodBread, 5L, new Day()),
                new FoodConsumption(foodMeat, 10L, new Day())
        );
        List<FoodConsumption> foodConsumptions2 = asList(
                new FoodConsumption(foodMushrooms, 8L, new Day()),
                new FoodConsumption(foodEgg, 4L, new Day())
        );
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse("2019-04-01", formatter);
        List<Day> days = asList(
                new Day(localDate, user1, foodConsumptions1),
                new Day(localDate, user2, foodConsumptions2)
        );
        List<Day> daysList = asList(new Day(localDate, user1, foodConsumptions1));
        days.forEach(repository::save);
        assertEquals(daysList, repository.findDayByFoodAndUser(foodMeat, user1));
    }

    @Test
    public void findDayByUser() {
        User user1 = new User("1", "1");
        User user2 = new User("2", "2");
        List<FoodConsumption> food = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse("2019-04-01", formatter);
        List<Day> days = asList(
                new Day(localDate, user1, food),
                new Day(localDate, user2, food)
        );
        List<Day> daysList = asList(new Day(localDate, user1, food));
        days.forEach(repository::save);
        assertEquals(daysList, repository.findDayByUser(user1));
    }

    @Test
    public void findDayByDate() {
        User user = new User();
        List<FoodConsumption> food = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate1 = LocalDate.parse("2019-04-01", formatter);
        LocalDate localDate2 = LocalDate.parse("2019-04-02", formatter);
        LocalDate localDate3 = LocalDate.parse("2019-04-03", formatter);
        List<Day> days = asList(
                new Day(localDate1, user, food),
                new Day(localDate2, user, food),
                new Day(localDate3, user, food)
        );
        Day day = new Day(localDate1, user, food);
        days.forEach(repository::save);
        assertEquals(day, repository.findDayByDate(localDate1).get());
    }
}*/
