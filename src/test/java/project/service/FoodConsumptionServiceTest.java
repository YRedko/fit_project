package project.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import project.dao.DayRepository;
import project.dao.FoodConsumptionRepository;
import project.dao.FoodRepository;
import project.domain.Day;
import project.domain.Food;
import project.domain.FoodConsumption;
import project.domain.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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
    @Mock
    private DayRepository dayRepository;
    @Mock
    private FoodRepository foodRepository;

    @Test
    public void addFoodConsumptionToDay() {
        Food food = new Food(1L, "Food", 120L, 12L, 5L, 28L);
        Day day = new Day();
        FoodConsumption foodConsumption = new FoodConsumption(food, 10L, day);
        when(foodConsumptionRepository.findById(1L)).thenReturn(Optional.of(foodConsumption));
        User user = new User("login", "password");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate1 = LocalDate.parse("2019-05-01", formatter);
        when(dayRepository.findDayByDate(localDate1)).thenReturn(Optional.of(day));
        when(foodRepository.findById(1L)).thenReturn(Optional.of(food));
        foodConsumptionService.addFoodConsumptionToDay(localDate1, 1L, 10L, user);

        //verify(foodConsumptionRepository).findById(1L);
        verify(foodConsumptionRepository).save(refEq(new FoodConsumption(null, food, 10L, day)));
        verifyNoMoreInteractions(foodConsumptionRepository);
    }

//    @Test
//    public void getFoodByDateAndUser() {
//        User user = new User(1L,"login", "password");
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate localDate = LocalDate.parse("2019-10-15", formatter);
//        Day day = new Day(localDate, user);
//        FoodConsumption foodConsumption = new FoodConsumption();
//        foodConsumption.setDay(day);
//        List<FoodConsumption> foodConsumptionList = new ArrayList<>();
//        foodConsumptionList.add(foodConsumption);
//        when(foodConsumptionRepository.findByDateAndUser(localDate, user)).thenReturn(foodConsumptionList);
//        List<FoodConsumption> foodConsumptionListByDateAndUser = foodConsumptionService.getFoodByDateAndUser(localDate, user);
//        assertEquals(foodConsumptionList, foodConsumptionListByDateAndUser);
//    }

    @Test
    public void delete() {
        foodConsumptionService.delete(1L);
        verify(foodConsumptionRepository).deleteById(1L);
        verifyNoMoreInteractions(foodConsumptionRepository);
    }
}