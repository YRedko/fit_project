package project.dao;

import project.domain.FoodConsumption;
import project.domain.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FoodConsumptionRepository {

    FoodConsumption save(FoodConsumption foodConsumption);

    List<FoodConsumption> findAll();

    List<FoodConsumption> findByDateAndUser(LocalDate date, User user);

    Optional<FoodConsumption> findById(Long id);

    void delete(Long id);
}
