package project.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.domain.Food;
import project.domain.FoodDto;
import project.domain.User;
import project.service.FoodService;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/food")
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;
    private final HttpSession httpSession;

    @PostMapping("/create")
    public Food create(FoodDto foodDto) {
        Food food = new Food(foodDto.getName(), foodDto.getCalories(), foodDto.getProtein(), foodDto.getFat(), foodDto.getCarbs());
        return foodService.addFoodToGlobalList(food);
    }

    @GetMapping("/all")
    public List<Food> getAll(){
        return foodService.getAllFood();
    }

    @PostMapping("/delete")
    public void delete(Long id){ foodService.delete(id);}

    private User getUser(){
        return (User) httpSession.getAttribute("user");
    }
}