package project.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.domain.Day;
import project.domain.User;
import project.domain.dto.DayDto;
import project.domain.dto.DayMapper;
import project.service.DayService;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/day")
@RequiredArgsConstructor
public class DayController {

    private final DayService dayService;
    private final HttpSession httpSession;
    private final DayMapper dayMapper;

    @PostMapping
    public Day create(DayDto day) {
       return dayService.createDay(dayMapper.toDay(day), getUser());
    }

    @GetMapping("/own")
    public List<Day> ownDays(){
        return dayService.getDaysByUser(getUser());
    }

    private User getUser(){
        return (User) httpSession.getAttribute("user");
    }
}
