package project.dao;

import project.domain.Day;
import project.domain.Food;
import project.domain.User;

import java.util.List;
import java.util.Optional;

public interface FoodRepository {

    Food save(Food food);

    List<Food> findAll();

    List<Food> findByName(String name);

    List<Food> findByDayAndUser(Day day, User user);

    Optional<Food> findById(Long id);

    void delete(Long id);

}
