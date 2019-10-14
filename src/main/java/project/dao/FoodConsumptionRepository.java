package project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.domain.FoodConsumption;
import project.domain.User;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface FoodConsumptionRepository extends JpaRepository<FoodConsumption, Long> {

//    @Query("select fc from FoodConsumption  fc where fc.day.date = :date and fc.day.user = :user")
//    List<FoodConsumption> findByDateAndUser(@Param("date") Date date, @Param("user") User user);

//    FoodConsumption save(FoodConsumption foodConsumption);
//
//    List<FoodConsumption> findAll();
//
//    List<FoodConsumption> findByDateAndUser(LocalDate date, User user);
//
//    Optional<FoodConsumption> findById(Long id);
//
//    void delete(Long id);
}
