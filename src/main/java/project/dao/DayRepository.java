package project.dao;

import project.domain.Day;
import project.domain.Food;
import project.domain.User;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DayRepository {

    Day save(Day day);

    //Day update(Day day, Food food, Long addCalories);

    List<Day> findAll();

    List<Day> findDayByFoodAndUser(Food food, User user);

    List<Day> findDayByUser(User user);

    Optional<Day> findDayByDate(LocalDate date);

    Optional<Day> findById(Long id);

}
