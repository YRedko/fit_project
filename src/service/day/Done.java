package service.day;

import domain.Day;

import static service.day.DayStateEnum.DONE;
import static service.day.DayStateEnum.EXCEEDED;

public class Done extends DayState {

    @Override
    public DayStateEnum getStatusName() {
        return DONE;
    }

    @Override
    public void exceed(Day day){
        day.setStatus(EXCEEDED);
    }
}
