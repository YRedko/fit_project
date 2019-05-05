package project.dao.inmemory;

import org.junit.Test;
import project.domain.Day;
import project.domain.Food;
import project.domain.FoodConsumption;
import project.domain.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class FoodConsumptionInMemoryRepositoryTest {

    private FoodConsumptionInMemoryRepository repository = new FoodConsumptionInMemoryRepository();

    @Test
    public void save() {
        List<FoodConsumption> foods = asList(
                new FoodConsumption(),
                new FoodConsumption()
        );
        foods.forEach(repository::save);
        assertEquals(foods, repository.findAll());
    }

    @Test
    public void findByDateAndUser() {
        Food food1 = new Food(1L, "1", 1L, 1L, 1L, 1L );
        Food food2 = new Food(2L, "2", 2L, 2L, 2L, 2L );
        Food food3 = new Food(3L, "3", 3L, 3L, 3L, 3L );
        User user1 = new User("1", "1");
        User user2 = new User("2", "2");
        User user3 = new User("3", "3");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate1 = LocalDate.parse("2019-04-01", formatter);
        LocalDate localDate2 = LocalDate.parse("2019-04-02", formatter);
        LocalDate localDate3 = LocalDate.parse("2019-04-03", formatter);
        FoodConsumption foodConsumption1 = new FoodConsumption(food1, 10L, new Day(localDate1, user1));
        FoodConsumption foodConsumption2 = new FoodConsumption(food2, 12L, new Day(localDate2, user2));
        FoodConsumption foodConsumption3 = new FoodConsumption(food3, 20L, new Day(localDate3, user3));
        List<FoodConsumption> foods = asList(
                foodConsumption1,
                foodConsumption2,
                foodConsumption3
        );
        List<FoodConsumption> foodConsumptions = asList(
                foodConsumption3
        );
        foods.forEach(repository::save);
        assertEquals(foodConsumptions, repository.findByDateAndUser(localDate3, user3));
    }

    @Test
    public void findById() {
        Food food1 = new Food(1L, "1", 1L, 1L, 1L, 1L );
        Food food2 = new Food(2L, "2", 2L, 2L, 2L, 2L );
        Food food3 = new Food(3L, "3", 3L, 3L, 3L, 3L );
        User user1 = new User("1", "1");
        User user2 = new User("2", "2");
        User user3 = new User("3", "3");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate1 = LocalDate.parse("2019-04-01", formatter);
        LocalDate localDate2 = LocalDate.parse("2019-04-02", formatter);
        LocalDate localDate3 = LocalDate.parse("2019-04-03", formatter);
        FoodConsumption foodConsumption1 = new FoodConsumption(1L, food1, 10L, new Day(localDate1, user1));
        FoodConsumption foodConsumption2 = new FoodConsumption(2L, food2, 12L, new Day(localDate2, user2));
        FoodConsumption foodConsumption3 = new FoodConsumption(3L, food3, 20L, new Day(localDate3, user3));
        List<FoodConsumption> foods = asList(
                foodConsumption1,
                foodConsumption2,
                foodConsumption3
        );
        foods.forEach(repository::save);
        assertEquals(foodConsumption3, repository.findById(3L).get());
    }

    @Test
    public void delete() {
        Food food1 = new Food(1L, "1", 1L, 1L, 1L, 1L );
        Food food2 = new Food(2L, "2", 2L, 2L, 2L, 2L );
        Food food3 = new Food(3L, "3", 3L, 3L, 3L, 3L );
        User user1 = new User("1", "1");
        User user2 = new User("2", "2");
        User user3 = new User("3", "3");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate1 = LocalDate.parse("2019-04-01", formatter);
        LocalDate localDate2 = LocalDate.parse("2019-04-02", formatter);
        LocalDate localDate3 = LocalDate.parse("2019-04-03", formatter);
        FoodConsumption foodConsumption1 = new FoodConsumption(1L, food1, 10L, new Day(localDate1, user1));
        FoodConsumption foodConsumption2 = new FoodConsumption(2L, food2, 12L, new Day(localDate2, user2));
        FoodConsumption foodConsumption3 = new FoodConsumption(3L, food3, 20L, new Day(localDate3, user3));
        List<FoodConsumption> foods = asList(
                foodConsumption1,
                foodConsumption2,
                foodConsumption3
        );
        List<FoodConsumption> foodConsumptions = asList(
                foodConsumption1,
                foodConsumption3
        );
        foods.forEach(repository::save);
        repository.delete(2L);
        assertEquals(foodConsumptions, repository.findAll());
    }
}