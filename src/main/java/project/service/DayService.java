package project.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project.dao.DayRepository;
import project.domain.Day;
import project.domain.Food;
import project.domain.FoodConsumption;
import project.domain.User;
import project.exeptions.BussinesException;
import project.exeptions.EntityNotFound;

import java.time.LocalDate;
import java.util.List;

@Service
public class DayService {

    private final DayRepository dayRepository;

    public DayService(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }

//    public List<Day> getDaysByFoodAndUser(Food food, User user){
//        return this.dayRepository.findDayByFoodAndUser(food, user);
//    }

    public List<Day> getDaysByUser(User user){
        return this.dayRepository.findDaysByOwnerId(user.getId());
    }

    public Page<Day> getAllDays(Pageable pageable){//need fot test
        return this.dayRepository.findAll(pageable);
    }

    public Day getDayByDate(LocalDate date){
        return dayRepository.findDayByDate(date).orElseThrow(EntityNotFound::new);
    }

    private Day getDay(Long id){
        return dayRepository.findById(id).orElseThrow(EntityNotFound::new);
    }

    private Long caloriesPerDay(LocalDate date){
        List<FoodConsumption> eatenFood = dayRepository.findDayByDate(date).get().getEatenFood();
        Long dailyCalories = 0L;
        for (FoodConsumption foodConsumption : eatenFood) {
            dailyCalories += foodConsumption.getSize() * foodConsumption.getFood().getCalories();
        }
        return dailyCalories;
    }

    private void assertIsNull(LocalDate date, String message) {
        if (date != null) {
            throw new BussinesException(message);
        }
    }
}
