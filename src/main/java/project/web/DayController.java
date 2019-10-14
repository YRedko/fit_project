package project.web;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/day")
@RequiredArgsConstructor
public class DayController {

    private final DayService dayService;
    private final HttpSession httpSession;
    private final DayMapper dayMapper;

    @GetMapping("/own")
    public List<Day> ownDays(){
        return dayService.getDaysByUser(getUser());
    }

    @GetMapping("/all")
    public Page<Day> allDays(int page, int size){//need for test
        Pageable pageable = PageRequest.of(page, size);
        return dayService.getAllDays(pageable);
    }

    @GetMapping("/own_by_date")
    public Day dayByDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return dayService.getDayByDate(localDate);
    }

//    @GetMapping("/own_by_food")
//    public List<Day> ownDaysByFood() { return dayService.getDaysByFoodAndUser()}

    private User getUser(){
        return (User) httpSession.getAttribute("user");
    }
}
