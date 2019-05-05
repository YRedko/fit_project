package project.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.domain.Food;
import project.domain.FoodConsumption;
import project.domain.User;
import project.service.FoodConsumptionService;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/food_consumption")
@RequiredArgsConstructor
public class FoodConsumptionController {

    private final FoodConsumptionService foodConsumptionService;
    private final HttpSession httpSession;

    @PostMapping("/add")
    public FoodConsumption addToDay(String date, Long foodId, Long size){
        return foodConsumptionService.addFoodConsumptionToDay(date, foodId, size);
    }

    @GetMapping("/own_by_day")
    public List<FoodConsumption> ownByDay(String date){
        return foodConsumptionService.getFoodByDateAndUser(date, getUser());
    }

    @PostMapping("/delete")
    public void delete(Long id){ foodConsumptionService.delete(id);}

    private User getUser(){
        return (User) httpSession.getAttribute("user");
    }
}
