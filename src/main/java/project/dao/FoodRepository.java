package project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import project.domain.Food;

import java.util.List;
import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {

//    Food save(Food food);
//
//    List<Food> findAll();
//
//    List<Food> findByName(String name);
//
//    Optional<Food> findById(Long id);
//
//    void delete(Long id);

}
