package project.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.domain.Food;
import project.domain.FoodConsumption;
import project.domain.User;
import project.service.FoodConsumptionService;

import javax.servlet.http.HttpSession;
import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/food_consumption")
@RequiredArgsConstructor
public class FoodConsumptionController {

    private final FoodConsumptionService foodConsumptionService;
    private final HttpSession httpSession;

    @PostMapping("/add")
    public FoodConsumption addToDay(@RequestParam(value = "date", required = false) String date, Long foodId, Long size){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return foodConsumptionService.addFoodConsumptionToDay(localDate, foodId, size, getUser());
    }

    @GetMapping("/own_by_day")
    public List<FoodConsumption> ownByDay(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return foodConsumptionService.getFoodByDateAndUser(localDate, getUser());
    }

    @PostMapping("/delete")
    public void delete(Long id){ foodConsumptionService.delete(id);}

    private User getUser(){
        return (User) httpSession.getAttribute("user");
    }
}
