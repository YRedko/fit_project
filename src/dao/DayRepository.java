package dao;

import domain.Day;
import domain.Food;

import java.util.List;
import java.util.Optional;

public interface DayRepository {

    Day save(Day day);

    List<Day> findDayByFood(Food food);

    Optional<Day> findById(Long id);

}
