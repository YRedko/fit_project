package service.day;

import domain.Day;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StateMachine {

    private final Map<DayStateEnum, DayState> states = new ConcurrentHashMap<>();

    public StateMachine(List<DayState> dayStatus) {
        dayStatus.forEach(status -> states.put(status.getStatusName(), status));
    }

    private DayState getState(Day day){
        return states.get(day.getStatus());
    }

    public void perform(Day day){
        getState(day).perform(day);
    }

    public void exceed(Day day){
        getState(day).perform(day);
    }
}
