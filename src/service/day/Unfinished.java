package service.day;

import domain.Day;

import static service.day.DayStateEnum.DONE;
import static service.day.DayStateEnum.UNFINISHED;

public class Unfinished extends DayState {

    @Override
    public DayStateEnum getStatusName() {
        return UNFINISHED;
    }

    @Override
    public void perform(Day day){
        day.setStatus(DONE);
    }
}
