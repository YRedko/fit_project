package project.dao;

import project.domain.Day;
import project.domain.Food;
import project.domain.User;

import java.util.List;
import java.util.Optional;

public interface DayRepository {

    Day save(Day day);

    Day update(Day day, Food food, Long addCalories);

    List<Day> findDayByFoodAndUser(Food food, User user);

    List<Day> findDayByUser(User user);

    Optional<Day> findById(Long id);

}
