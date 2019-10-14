package project.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.domain.Food;
import project.domain.FoodConsumption;
import project.domain.User;
import project.domain.dto.FoodConsumptionDto;
import project.service.FoodConsumptionService;

import javax.servlet.http.HttpSession;
import javax.swing.text.DateFormatter;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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

    @PutMapping("/{id}")
    public FoodConsumption update(@PathVariable("id") Long id, @Valid @RequestBody FoodConsumptionDto foodConsumptionDto) {
        return foodConsumptionService.editFoodConsumption(id, foodConsumptionDto);
    }

//    @GetMapping("/own_by_day")
//    public List<FoodConsumption> ownByDay(String date){
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate localDate = LocalDate.parse(date, formatter);
//        return foodConsumptionService.getFoodByDateAndUser(localDate, getUser());
//    }

    @PostMapping("/delete")
    public void delete(Long id){ foodConsumptionService.delete(id);}

    private User getUser(){
        return (User) httpSession.getAttribute("user");
    }
}
