package project.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import project.domain.User;
import project.domain.UserDto;
import project.service.UserService;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final HttpSession httpSession;

    @PostMapping("/login")
    public User login(UserDto userDto){
        User user = userService.login(userDto);
        httpSession.setAttribute("user", user);
        return user;
    }

    @PostMapping("/register")
    public User register(UserDto userDto){
        return userService.registerUser(userDto);
    }
}
