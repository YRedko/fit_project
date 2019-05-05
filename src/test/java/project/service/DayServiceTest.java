package project.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import project.dao.DayRepository;
import project.domain.Day;
import project.domain.Food;
import project.domain.FoodConsumption;
import project.domain.User;
import project.exeptions.EntityNotFound;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DayServiceTest {

    @InjectMocks
    private DayService dayService;

    @Mock
    private DayRepository dayRepository;

    @Test
    public void createDay() {
        User user = new User("user", "password");
        User wrongUser = new User("wrongUser", "anotherPassword");
        FoodConsumption foods = new FoodConsumption(1L, asList(new Food(1L, "Food", 120L, 12L, 5L, 28L)));
        Day day = new Day(Instant.now(), "Unfinished", wrongUser, 0L, foods);

        when(dayRepository.save(day)).thenReturn(day);
        Day dayResult = dayService.createDay(day, user);

        assertNotNull(dayResult);
        assertEquals(dayResult.getOwner(), user);

        verify(dayRepository).save(refEq(day));

        verifyNoMoreInteractions(dayRepository);
    }

    @Test
    public void addFoodToDay() {
        Food food = new Food(1,"1", 1L,1L,1L,1L);
        FoodConsumption foods = new FoodConsumption(1L, asList(food));
        User mockUser = new User("login", "password");
        Day mockDay = new Day(Instant.now(), "Unfinished", mockUser, 0L, foods);

        when(dayRepository.findById(1L)).thenReturn(Optional.of(mockDay));
        dayService.addFoodToDay(1L, mockUser, food, 10L);

        verify(dayRepository).findById(1L);
        verify(dayRepository).update(refEq(mockDay), refEq(food), eq(10L));
        verifyNoMoreInteractions(dayRepository);
    }

    @Test(expected = EntityNotFound.class)
    public void dayNotFound(){
        when(dayRepository.findById(1L)).thenReturn(Optional.empty());
        dayService.addFoodToDay(1L, new User(), new Food(foodDto.getName(), foodDto.getCalories(), foodDto.getProtein(), foodDto.getFat(), foodDto.getCarbs()), 12L);
    }

    @Test
    public void getDaysByFoodAndUser() {
        Day day1 = new Day();
        Day day2 = new Day();
        day1.setId(1L);
        day2.setId(2L);
        User user1 = new User("login 1", "password 1");
        Food food1 = new Food(1,"1", 1L,1L,1L,1L);
        food1.setDay(day1);

        FoodConsumption firstFoodList =  new FoodConsumption(1L, asList(food1));
        List<Day> days = asList(new Day(Instant.ofEpochSecond(3600),"1", user1, 1L, firstFoodList),
                new Day(Instant.ofEpochSecond(7200), "2", user1, 2L, firstFoodList));

        when(dayRepository.findDayByFoodAndUser(food1, user1)).thenReturn(days);
        List<Day> daysByFoodAndUser = dayService.getDaysByFoodAndUser(food1, user1);

        assertEquals(days, daysByFoodAndUser);
    }
}