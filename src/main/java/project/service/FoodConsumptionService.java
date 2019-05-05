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

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    public FoodConsumption addFoodConsumptionToDay(LocalDate date, Long foodId, Long size, User user){
        Optional<Day> dayOptional = dayRepository.findDayByDate(date);
        Day day = new Day();
        if(dayOptional.isPresent()){
            day = dayOptional.get();
        }else {
            if(date != null){
                day.setDate(date);
            }else{
                day.setDate(LocalDate.now());
            }
            day.setOwner(user);
            dayRepository.save(day);
        }
        Food food = foodRepository.findById(foodId).orElseThrow(EntityNotFound::new);
        FoodConsumption foodConsumption = new FoodConsumption(food, size, day);
        //day.getEatenFood().add(foodConsumption);
        //dayRepository.save()
        return foodConsumptionRepository.save(foodConsumption);
    }

    public List<FoodConsumption> getFoodByDateAndUser(LocalDate date, User user){
        return foodConsumptionRepository.findByDateAndUser(date, user);
    }

    public void delete(Long id){
        foodConsumptionRepository.delete(id);
    }

    private FoodConsumption getFoodConsumption(Long id){
        return foodConsumptionRepository.findById(id).orElseThrow(EntityNotFound::new);
    }

    private void assertIsNull(LocalDate date, String message) {
        if (date != null) {
            throw new BussinesException(message);
        }
    }
}
