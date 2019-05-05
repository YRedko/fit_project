package project.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import project.dao.FoodRepository;
import project.domain.Day;
import project.domain.Food;
import project.domain.User;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FoodServiceTest {

    @InjectMocks
    private FoodService foodService;

    @Mock
    private FoodRepository foodRepository;

    @Test
    public void addFoodToGlobalList() {
        Food food = new Food(1L, "Food", 120L, 12L, 5L, 28L);
        when(foodRepository.findById(1L)).thenReturn(Optional.of(food));
        foodService.addFoodToGlobalList(food);
        //verify(foodRepository).findById(1L);
        verify(foodRepository).save(refEq(new Food(1L, "Food", 120L, 12L, 5L, 28L)));
        verifyNoMoreInteractions(foodRepository);
    }

//    @Test
//    public void getDayFood() {
//        Day day = new Day();
//        day.setId(1L);
//        User user = new User("user login", "password");
//        List<Food> foods = asList(new Food(1,"1", 1L,1L,1L,1L), new Food(2,"2", 2L,2L,2L,2L));
//        when(foodRepository.findByDayAndUser(day, user)).thenReturn(foods);
//        List<Food> dayFood = foodService.getDayFood(day, user);
//        assertEquals(foods, dayFood);
//    }

    @Test
    public void delete() {
        foodService.delete(1L);
        verify(foodRepository).delete(1L);
        verifyNoMoreInteractions(foodRepository);
    }
}