package service;

import dao.DayRepository;
import domain.Day;
import domain.Food;
import domain.User;
import exeptions.BussinesException;
import exeptions.EntityNotFound;
import service.day.StateMachine;

import java.util.List;

public class DayService {

    private final DayRepository dayRepository;
    private final StateMachine stateMachine;

    public DayService(DayRepository dayRepository, StateMachine stateMachine) {
        this.dayRepository = dayRepository;
        this.stateMachine = stateMachine;
    }

    public Day createDay(Day day, User user){
        assertIsNull(day.getId(),"Id already exists.");
        day.setOwner(user);
        return dayRepository.save(day);
    }

    public List<Day> getDaysByFood(Food food){
        return this.dayRepository.findDayByFood(food);
    }

    private Day getDay(Long id){
        return dayRepository.findById(id).orElseThrow(EntityNotFound::new);
    }

    private void assertIsNull(Long id, String message) {
        if (id != null) {
            throw new BussinesException(message);
        }
    }
}
