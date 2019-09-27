package project.dao.inmemory;

import org.springframework.stereotype.Repository;
import project.dao.DayRepository;
import project.domain.Day;
import project.domain.Food;
import project.domain.FoodConsumption;
import project.domain.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import static java.util.stream.Collectors.toList;
@Repository
public class DayInMemoryRepository implements DayRepository {

    private List<Day> days = new ArrayList<>();

    //private AtomicLong counter = new AtomicLong(0);
    private AtomicLong counterFoodConsumption = new AtomicLong(0);

    @Override
    public Day save(Day day) {
        if(day.getDate() == null){
            LocalDate localDate = LocalDate.now();
            day.setDate(localDate);
        }
        days.add(day);
        return day;
    }

//    @Override
//    public Day update(Day day, Food food, Long newCalories){
//        FoodConsumption meal = new FoodConsumption();
//        if(meal.getId() == null){
//            meal.setId(counterFoodConsumption.incrementAndGet());
//        }
//        meal.setFood(food);
//        day.getEatenFood().getDailyMealSet().add(food);
//        day.setCalories(newCalories);
//        return day;
//    }

    @Override
    public List<Day> findAll() {
        return new ArrayList<>(days);
    }

    @Override
    public List<Day> findDayByFoodAndUser(Food food, User user) {
        List<Day> list = new ArrayList<>();
        for (Day day : days) {
            for(FoodConsumption eatenFood: day.getEatenFood()) {
                if (eatenFood.getFood().equals(food) && day.getOwner().equals(user)) {
                    list.add(day);
                    break;
                }
            }
        }
        return list;
    }
    //return days.stream().filter(day -> day.getFood().equals(food)).collect(toList());

    @Override
    public List<Day> findDayByUser(User user){
        return days.stream().filter(day -> day.getOwner().equals(user)).collect(toList());
    }

    @Override
    public Optional<Day> findDayByDate(LocalDate date){
        return days.stream().filter(day -> day.getDate().equals(date)).findFirst();
    }

    @Override
    public Optional<Day> findById(Long id) { return days.stream().filter(day -> day.getId().equals(id)).findAny(); }
}
