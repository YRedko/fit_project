package service.day;

import static service.day.DayStateEnum.EXCEEDED;

public class Exceeded extends DayState {

    @Override
    public DayStateEnum getStatusName() {
        return EXCEEDED;
    }

}
