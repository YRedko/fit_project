package project.dao;

import project.domain.FoodConsumption;
import project.domain.User;

import java.util.List;

public interface FoodConsumptionRepository {

    FoodConsumption save(FoodConsumption foodConsumption);

    List<FoodConsumption> findByDateAndUser(String date, User user);

    void delete(Long id);
}
