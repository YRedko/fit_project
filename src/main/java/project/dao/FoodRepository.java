package project.dao;

import project.domain.Food;

import java.util.List;
import java.util.Optional;

public interface FoodRepository {

    Food save(Food food);

    List<Food> findAll();

    List<Food> findByName(String name);

    Optional<Food> findById(Long id);

    void delete(Long id);

}
