package project;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import project.configuration.ApplicationFactory;
import project.domain.Day;
import project.domain.User;
import project.domain.UserDto;
import project.service.DayService;



@SpringBootApplication//(exclude={DataSourceAutoConfiguration.class})
public class FitProjectApp {

    public static void main(String[] args) {
        //ApplicationFactory.userService.registerUser(new UserDto());
        ApplicationContext context = SpringApplication.run(FitProjectApp.class, args);
        DayService dayService = context.getBean(DayService.class);
        User user1 = new User("l", "2");
        User user = new User("login", "password");
        System.out.println(user);
    }
}
