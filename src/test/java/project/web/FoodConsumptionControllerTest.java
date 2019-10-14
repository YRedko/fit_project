package project.web;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import project.domain.FoodConsumption;
import project.domain.User;
import project.service.FoodConsumptionService;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = FoodConsumptionController.class)
@ContextConfiguration(classes = {FoodConsumption.class, ExceptionController.class, FoodConsumptionController.class})
public class FoodConsumptionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FoodConsumptionController foodConsumptionController;

    @MockBean
    private FoodConsumptionService foodConsumptionService;

    @Test
    public void addToDay() throws Exception {
        Map<String, Object> sessionattr = new HashMap<>();
        sessionattr.put("user", new User());

        mockMvc.perform(post("/api/food_consumption/add").sessionAttrs(sessionattr))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void update() throws Exception {
        Map<String, Object> sessionattr = new HashMap<>();
        sessionattr.put("user", new User());

        mockMvc.perform(post("/api/food_consumption/1").sessionAttrs(sessionattr))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void delete() throws Exception {
        Map<String, Object> sessionattr = new HashMap<>();
        sessionattr.put("user", new User());

        mockMvc.perform(post("/api/food_consumption/delete").sessionAttrs(sessionattr))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
