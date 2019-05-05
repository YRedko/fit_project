package project.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import project.dao.FoodConsumptionRepository;
import project.domain.Day;
import project.domain.Food;
import project.domain.FoodConsumption;
import project.domain.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FoodConsumptionServiceTest {

    @InjectMocks
    private FoodConsumptionService foodConsumptionService;

    @Mock
    private FoodConsumptionRepository foodConsumptionRepository;

    @Test
    public void addFoodConsumptionToDay() {
        Food food = new Food(1L, "Food", 120L, 12L, 5L, 28L);
        Day day = new Day();
        FoodConsumption foodConsumption = new FoodConsumption(food, 10L, day);
        when(foodConsumptionRepository.findById(1L)).thenReturn(Optional.of(foodConsumption));
        User user = new User("login", "password");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate1 = LocalDate.parse("2019-05-01", formatter);
        foodConsumptionService.addFoodConsumptionToDay(localDate1, 1L, 10L, user);

        //verify(foodConsumptionRepository).findById(1L);
        verify(foodConsumptionRepository).save(refEq(new FoodConsumption(1L, food, 10L, day)));
    }

    @Test
    public void getFoodByDateAndUser() {
    }

    @Test
    public void delete() {
        foodConsumptionService.delete(1L);
        verify(foodConsumptionRepository).delete(1L);
        verifyNoMoreInteractions(foodConsumptionRepository);
    }
}