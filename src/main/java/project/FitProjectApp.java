package project;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import project.configuration.ApplicationFactory;
import project.domain.Day;
import project.domain.User;
import project.domain.UserDto;
import project.service.DayService;



@SpringBootApplication
public class FitProjectApp {

    public static void main(String[] args) {
        //ApplicationFactory.userService.registerUser(new UserDto());
        //System.out.println("Hello World");
        ApplicationContext context = SpringApplication.run(FitProjectApp.class, args);
        DayService dayService = context.getBean(DayService.class);
        User user = new User("login", "password");
        System.out.println(user);
    }
}
