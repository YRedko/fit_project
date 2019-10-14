package project.web;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import project.domain.Food;
import project.domain.dto.FoodDto;
import project.domain.User;
import project.service.FoodService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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
    public Page<Food> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return foodService.getAllFood(pageable);
    }

    @PutMapping("/{id}")
    public Food update(@PathVariable("id") Long id, @Valid @RequestBody FoodDto foodDto) {
        return foodService.editFood(id, foodDto);
    }

    @PostMapping("/delete")
    public void delete(Long id){ foodService.delete(id);}

    private User getUser(){
        return (User) httpSession.getAttribute("user");
    }
}
