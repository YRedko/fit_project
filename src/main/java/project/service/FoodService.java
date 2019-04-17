package project.service;

import org.springframework.stereotype.Service;
import project.dao.DayRepository;
import project.dao.FoodRepository;
import project.domain.Food;
import project.exeptions.EntityNotFound;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public Food addFoodToGlobalList(Food food){
        //Long id, String name, Long calories, Long protein, Long fat, Long carbs
        //Day day = dayRepository.findById(id).orElseThrow(EntityNotFound::new);
        //Food food = new Food(name, calories, protein, fat, carbs);
        return foodRepository.save(food);
    }

    private Food getFood(Long id){
        return foodRepository.findById(id).orElseThrow(EntityNotFound::new);
    }

    public void delete(Long id){
        foodRepository.delete(id);
    }
}
