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
import project.service.DayService;
import project.exeptions.EntityNotFound;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
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
    public void getDaysByUser(){
        User user = new User(1L,"login", "password");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse("2019-10-15", formatter);
        Day day = new Day(localDate, user);

        List<Day> dayList = Collections.singletonList(day);
        when(dayRepository.findDaysByOwnerId(1L)).thenReturn(dayList);
        List<Day> dayListByUser = dayService.getDaysByUser(user);
        assertEquals(dayList, dayListByUser);
    }

    @Test
    public void getDayByDate(){
        User user = new User(1L,"login", "password");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse("2019-10-15", formatter);
        Day day = new Day(localDate, user);

        when(dayRepository.findDayByDate(localDate)).thenReturn(Optional.of(day));
        Day dayByDate = dayService.getDayByDate(localDate);
        assertEquals(day, dayByDate);
    }

//    @Test
//    public void addFoodToDay() {
//        Food food = new Food(1,"1", 1L,1L,1L,1L);
//        List<FoodConsumption> foods = asList(
//                new FoodConsumption(1L, food, 5L, new Day())
//        );
//        User mockUser = new User("login", "password");
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate localDate1 = LocalDate.parse("2019-04-01", formatter);
//        Day mockDay = new Day(localDate1, mockUser, foods);
//
//        when(dayRepository.findById(1L)).thenReturn(Optional.of(mockDay));
//        dayService.addFoodToDay(1L, mockUser, food, 10L);
//
//        verify(dayRepository).findById(1L);
//        verify(dayRepository).update(refEq(mockDay), refEq(food), eq(10L));
//        verifyNoMoreInteractions(dayRepository);
//    }
//
//    @Test(expected = EntityNotFound.class)
//    public void dayNotFound(){
//        when(dayRepository.findById(1L)).thenReturn(Optional.empty());
//        dayService.addFoodToDay(1L, new User(), new Food(foodDto.getName(), foodDto.getCalories(), foodDto.getProtein(), foodDto.getFat(), foodDto.getCarbs()), 12L);
//    }

//    @Test
//    public void getDaysByFoodAndUser() {
//        User user1 = new User("login 1", "password 1");
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate localDate1 = LocalDate.parse("2019-04-01", formatter);
//        LocalDate localDate2 = LocalDate.parse("2019-04-02", formatter);
//        Day day1 = new Day(localDate1, user1);
//        Day day2 = new Day(localDate2, user1);
//        day1.setId(1L);
//        day2.setId(2L);
//        Food food1 = new Food(1,"1", 1L,1L,1L,1L);
//
//        List<FoodConsumption> firstFoodList = asList(new FoodConsumption(1L, food1, 17L, day1));
//        day1.setEatenFood(firstFoodList);
//        day2.setEatenFood(firstFoodList);
//
//        List<Day> days = asList( day1, day2 );
//
//        when(dayRepository.findDayByFoodAndUser(food1, user1)).thenReturn(days);
//        List<Day> daysByFoodAndUser = dayService.getDaysByFoodAndUser(food1, user1);
//
//        assertEquals(days, daysByFoodAndUser);
//    }
}