package exeptions;

public class StateTransitionException extends RuntimeException {
    public StateTransitionException(String message){
        super(message);
    }
}
