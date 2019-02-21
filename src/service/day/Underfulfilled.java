package service.day;

import domain.Day;

import static service.day.DayStateEnum.DONE;
import static service.day.DayStateEnum.UNDERFULFILLED;

public class Underfulfilled extends DayState {

    @Override
    public DayStateEnum getStatusName() {
        return UNDERFULFILLED;
    }

    @Override
    public void perform(Day day){
        day.setStatus(DONE);
    }

}
