package project.service;

import org.springframework.stereotype.Service;
import project.dao.DayRepository;
import project.domain.Day;
import project.domain.Food;
import project.domain.User;
import project.exeptions.BussinesException;
import project.exeptions.EntityNotFound;

import javax.xml.ws.ServiceMode;
import java.util.List;

@Service
public class DayService {

    private final DayRepository dayRepository;

    public DayService(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }

    public Day createDay(Day day, User user){
        assertIsNull(day.getId(),"Id already exists.");
        day.setOwner(user);
        return dayRepository.save(day);
    }

    public Day addFoodToDay(Long dayId, User user, Food food, Long size){
        Day day = getDay(dayId);
        return dayRepository.update(day, food, countCalories(food, size));
    }

    public List<Day> getDaysByFoodAndUser(Food food, User user){
        return this.dayRepository.findDayByFoodAndUser(food, user);
    }

    public List<Day> getDaysByUser(User user){
        return this.dayRepository.findDayByUser(user);
    }

    private Day getDay(Long id){
        return dayRepository.findById(id).orElseThrow(EntityNotFound::new);
    }

    private static Long countCalories(Food food, Long size){
        return food.getCalories()*size;
    }

    private void assertIsNull(Long id, String message) {
        if (id != null) {
            throw new BussinesException(message);
        }
    }
}
