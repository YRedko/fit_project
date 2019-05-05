package project.dao.inmemory;

import org.junit.Test;
import project.domain.Food;

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