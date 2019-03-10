package project.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import project.dao.FoodRepository;
import project.domain.Day;

//import static com.sun.javaws.JnlpxArgs.verify;
import static org.junit.Assert.*;
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
        //when()
        foodService.addFoodToGlobalList(1L, "Food", 120L, 12L, 5L, 28L);
    }

    @Test
    public void getDayFood() {
    }

    /*@Test
    public void delete() {
        foodService.delete(1L);
        verify(foodRepository).delete(1L);
        verifyNoMoreInteractions();
    }*/
}