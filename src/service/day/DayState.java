package service.day;

import domain.Day;
import exeptions.StateTransitionException;

public abstract class DayState {

    private void noStateTransition(Day day){
        throw new StateTransitionException("Illegal state transition" + day);
    }

    public abstract DayStateEnum getStatusName();

    public void perform(Day day){
        noStateTransition(day);
    }

    public void exceed(Day day){
        noStateTransition(day);
    }
}
