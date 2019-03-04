package project.dao.inmemory;

import project.dao.FoodRepository;
import project.domain.Day;
import project.domain.Food;
import project.domain.User;

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
    public List<Food> findByDayAndUser(Day day, User user) {
        List<Food> list = new ArrayList<>();
        for (Food food : foods) {
            if (food.getDay().equals(day) && day.getOwner().equals(user)) {
                list.add(food);
            }
        }
        return list;
    }

    @Override
    public Optional<Food> findById(Long id) {
        return foods.stream().filter(food -> food.getId().equals(id)).findAny();
    }

    @Override
    public void delete(Long id){
        foods.removeIf(food -> food.getId().equals(id));
    }

}
