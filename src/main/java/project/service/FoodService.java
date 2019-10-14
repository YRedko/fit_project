package project.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project.dao.FoodRepository;
import project.domain.Food;
import project.domain.dto.FoodDto;
import project.domain.dto.FoodMapper;
import project.exeptions.EntityNotFound;

import java.util.List;

@Service
public class FoodService {

    private final FoodRepository foodRepository;
    private final FoodMapper foodMapper;

    public FoodService(FoodRepository foodRepository, FoodMapper foodMapper) {
        this.foodRepository = foodRepository;
        this.foodMapper = foodMapper;
    }

    public Food addFoodToGlobalList(Food food){
        //Long id, String name, Long calories, Long protein, Long fat, Long carbs
        //Day day = dayRepository.findById(id).orElseThrow(EntityNotFound::new);
        //Food food = new Food(name, calories, protein, fat, carbs);
        return foodRepository.save(food);
    }

    public Page<Food> getAllFood(Pageable pageable){
        return foodRepository.findAll(pageable);
    }

    public Food editFood(Long id, FoodDto foodDto){
        Food food = getFood(id);
        if(food == null){
            throw new EntityNotFound();
        }
        Food updatedFood = foodMapper.toFood(foodDto);
        updatedFood.setId(id);
        return foodRepository.saveAndFlush(updatedFood);
    }

    public void delete(Long id){
        foodRepository.deleteById(id);
    }

    private Food getFood(Long id){
        return foodRepository.findById(id).orElseThrow(EntityNotFound::new);
    }
}
