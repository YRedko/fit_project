package project.service;

import org.springframework.stereotype.Service;
import project.dao.DayRepository;
import project.dao.FoodConsumptionRepository;
import project.dao.FoodRepository;
import project.domain.Day;
import project.domain.Food;
import project.domain.FoodConsumption;
import project.domain.User;
import project.exeptions.BussinesException;
import project.exeptions.EntityNotFound;

import java.util.List;

@Service
public class FoodConsumptionService {

    private final FoodConsumptionRepository foodConsumptionRepository;
    private final DayRepository dayRepository;
    private final FoodRepository foodRepository;

    public FoodConsumptionService(FoodConsumptionRepository foodConsumptionRepository, DayRepository dayRepository, FoodRepository foodRepository) {
        this.foodConsumptionRepository = foodConsumptionRepository;
        this.dayRepository = dayRepository;
        this.foodRepository = foodRepository;
    }

    public FoodConsumption addFoodConsumptionToDay(String date, Long foodId, Long size){
        Day day = dayRepository.findDayByDate(date).orElseThrow(EntityNotFound::new);
        Food food = foodRepository.findById(foodId).orElseThrow(EntityNotFound::new);
        FoodConsumption foodConsumption = new FoodConsumption(food, size, day);
        return foodConsumptionRepository.save(foodConsumption);
    }

    public List<FoodConsumption> getFoodByDateAndUser(String date, User user){
        return foodConsumptionRepository.findByDateAndUser(date, user);
    }

    public void delete(Long id){
        foodConsumptionRepository.delete(id);
    }

    private FoodConsumption getFoodConsumption(Long id){
        return foodConsumptionRepository.findById(id).orElseThrow(EntityNotFound::new);
    }

    private void assertIsNull(String date, String message) {
        if (date != null) {
            throw new BussinesException(message);
        }
    }
}
