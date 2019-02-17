package dao.inmemory;

import dao.FoodRepository;
import domain.Day;
import domain.Food;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import static java.util.stream.Collectors.toList;

public class FoodInMemoryRepository implements FoodRepository {

    private Set<Food> foods = new HashSet<>();

    private AtomicLong counter = new AtomicLong(0);

    @Override
    public Food save(Food food) {
        if(food.getId() == null){
            food.setId(counter.incrementAndGet());
        }
        foods.add(food);
        return food;
    }

    @Override
    public List<Food> findAll() {
        return new ArrayList<>(foods);
    }

    @Override
    public List<Food> findByName(String name) {
        return foods.stream().filter(food -> food.getName().equals(name)).collect(toList());
    }

    @Override
    public List<Food> findByDay(Day day) {
        return foods.stream().filter(food -> food.getDay().equals(day)).collect(toList());
    }

    @Override
    public Optional<Food> findById(Long id) {
        return foods.stream().filter(food -> food.getId().equals(id)).findAny();
    }
}
