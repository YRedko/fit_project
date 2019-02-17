package dao;

import domain.Day;
import domain.Food;

import java.util.List;
import java.util.Optional;

public interface FoodRepository {

    Food save(Food food);

    List<Food> findAll();

    List<Food> findByName(String name);

    List<Food> findByDay(Day day);

    Optional<Food> findById(Long id);

}
