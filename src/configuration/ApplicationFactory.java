package configuration;

import static java.util.Arrays.asList;

import dao.inmemory.DayInMemoryRepository;
import dao.inmemory.FoodInMemoryRepository;
import dao.inmemory.UserInMemoryRepository;
import service.DayService;
import service.FoodService;
import service.UserService;
import service.day.Done;
import service.day.Exceeded;
import service.day.StateMachine;
import service.day.Unfinished;

public class ApplicationFactory {
    public static final UserService userService;
    public static final FoodService foodService;
    public static final DayService dayService;

    static {
        userService = new UserService(new UserInMemoryRepository());
        FoodInMemoryRepository productRepository = new FoodInMemoryRepository();
        StateMachine stateMachine = new StateMachine(asList(
                new Unfinished(),
                new Done(),
                new Exceeded()));
        dayService = new DayService(new DayInMemoryRepository(), stateMachine);
        foodService = new FoodService(new FoodInMemoryRepository(), new DayInMemoryRepository());

    }
}
