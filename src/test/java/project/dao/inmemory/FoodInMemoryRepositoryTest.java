package project.dao.inmemory;

import org.junit.Test;
import project.domain.Day;
import project.domain.Food;
import project.domain.User;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class    FoodInMemoryRepositoryTest {

    private FoodInMemoryRepository repository = new FoodInMemoryRepository();

    @Test
    public void save() {
        List<Food> foods = asList(
                new Food(1L, "1", 1L, 1L, 1L, 1L ),
                new Food(2L, "2", 2L, 2L, 2L, 2L )
        );
        foods.forEach(repository::save);
        assertEquals(foods, repository.findAll());
    }

    @Test
    public void findByName() {
        List<Food> foods = asList(
                new Food(1L, "1", 1L, 1L, 1L, 1L ),
                new Food(2L, "2", 2L, 2L, 2L, 2L ),
                new Food(3L, "3", 3L, 3L, 3L, 3L ),
                new Food(4L, "3", 4L, 4L, 4L, 4L )
        );
        List<Food> food = new ArrayList<>(asList(
                new Food(3L, "3", 3L, 3L, 3L, 3L ),
                new Food(4L, "3", 4L, 4L, 4L, 4L )
        ));
        foods.forEach(repository::save);
        assertEquals(food, repository.findByName("3"));
    }

    @Test
    public void findByDayAndUser() {
        Day day1 = new Day();
        Day day2 = new Day();
        Day day3 = new Day();
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();

        day1.setOwner(user1);
        day2.setOwner(user2);
        day3.setOwner(user3);

        Food food1 = new Food(1L, "1", 1L, 1L, 1L, 1L );
        Food food2 = new Food(2L, "2", 2L, 2L, 2L, 2L );
        Food food3 = new Food(3L, "3", 3L, 3L, 3L, 3L );

        food1.setDay(day1);
        food2.setDay(day2);
        food3.setDay(day3);
        List<Food> foods = asList(food2);

        foods.forEach(repository::save);
        assertEquals(foods, repository.findByDayAndUser(day2, user2));
    }

    @Test
    public void findById() {
        List<Food> foods = asList(
                new Food(1L, "1", 1L, 1L, 1L, 1L ),
                new Food(2L, "2", 2L, 2L, 2L, 2L ),
                new Food(3L, "3", 3L, 3L, 3L, 3L ),
                new Food(4L, "3", 4L, 4L, 4L, 4L )
        );
        List<Food> food = new ArrayList<>(asList(
                new Food(3L, "3", 3L, 3L, 3L, 3L )
        ));
        foods.forEach(repository::save);
        assertEquals(food.get(0), repository.findById(3L).get());
    }

    @Test
    public void delete() {
        List<Food> foods = asList(
                new Food(1L, "1", 1L, 1L, 1L, 1L ),
                new Food(2L, "2", 2L, 2L, 2L, 2L ),
                new Food(3L, "3", 3L, 3L, 3L, 3L ),
                new Food(4L, "3", 4L, 4L, 4L, 4L )
        );
        List<Food> food = new ArrayList<>(asList(
                new Food(3L, "3", 3L, 3L, 3L, 3L ),
                new Food(4L, "3", 4L, 4L, 4L, 4L )
        ));
        foods.forEach(repository::save);

        repository.delete(1L);
        repository.delete(2L);

        assertEquals(food, repository.findAll());
    }
}