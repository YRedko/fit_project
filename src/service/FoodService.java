package service;

import dao.DayRepository;
import dao.FoodRepository;
import domain.Day;
import domain.Food;
import exeptions.EntityNotFound;

import java.util.List;

public class FoodService {

    private final FoodRepository foodRepository;
    private final DayRepository dayRepository;

    public FoodService(FoodRepository foodRepository, DayRepository dayRepository) {
        this.foodRepository = foodRepository;
        this.dayRepository = dayRepository;
    }

    public Food addFood(Long id, String name, Long calories, Long protein, Long fat, Long carbs){
        Day day = dayRepository.findById(id).orElseThrow(EntityNotFound::new);
        Food food = new Food(name, calories, protein, fat, carbs);
        return foodRepository.save(food);
    }

    public List<Food> getDayFood(Day day){
        return foodRepository.findByDay(day);
    }

    private Food getFood(Long id){
        return foodRepository.findById(id).orElseThrow(EntityNotFound::new);
    }

    public void delete(Long id){
        foodRepository.delete(id);
    }
}
