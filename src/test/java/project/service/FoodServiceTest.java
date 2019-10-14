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
import project.domain.dto.FoodDto;
import project.domain.dto.FoodMapper;

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
    @Mock
    private FoodMapper foodMapper;

    @Test
    public void addFoodToGlobalList() {
        Food food = new Food(1L, "Food", 120L, 12L, 5L, 28L);
        when(foodRepository.findById(1L)).thenReturn(Optional.of(food));
        foodService.addFoodToGlobalList(food);
        //verify(foodRepository).findById(1L);
        verify(foodRepository).save(refEq(new Food(1L, "Food", 120L, 12L, 5L, 28L)));
        verifyNoMoreInteractions(foodRepository);
    }

    @Test
    public void editFood(){
        Food food = new Food(1L, "Food", 120L, 12L, 5L, 28L);
        when(foodRepository.findById(1L)).thenReturn(Optional.of(food));
        foodService.addFoodToGlobalList(food);
        FoodDto foodDto = new FoodDto( "Food", 220L, 22L, 15L, 128L);
        when(foodMapper.toFood(foodDto)).thenReturn(new Food(1L, "Food", 220L, 22L, 15L, 128L));
        foodService.editFood(1L, foodDto);
        verify(foodRepository).save(refEq(new Food(1L, "Food", 220L, 22L, 15L, 128L)));
        verifyNoMoreInteractions(foodRepository);
    }

    @Test
    public void delete() {
        foodService.delete(1L);
        verify(foodRepository).deleteById(1L);
        verifyNoMoreInteractions(foodRepository);
    }
}