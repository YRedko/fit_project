package project.web;

import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import project.domain.Food;
import project.domain.User;
import project.service.FoodService;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = Food.class)
@ContextConfiguration(classes = {Food.class, ExceptionController.class, FoodController.class})
public class FoodControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FoodController foodController;

    @MockBean
    private FoodService foodService;

    @Test
    //@SneakyThrows
    public void create() throws Exception {
        Map<String, Object> sessionattr = new HashMap<>();
        sessionattr.put("user", new User());

        mockMvc.perform(post("/api/food/create").sessionAttrs(sessionattr))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    //@SneakyThrows
    public void getAll() throws Exception {
        Map<String, Object> sessionattr = new HashMap<>();
        sessionattr.put("user", new User());

        mockMvc.perform(get("/api/food/all").sessionAttrs(sessionattr))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    //@SneakyThrows
    public void update() throws Exception {
        Map<String, Object> sessionattr = new HashMap<>();
        sessionattr.put("user", new User());

        mockMvc.perform(put("/api/food/1").sessionAttrs(sessionattr))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    //@SneakyThrows
    public void delete() throws Exception {
        Map<String, Object> sessionattr = new HashMap<>();
        sessionattr.put("user", new User());

        mockMvc.perform(post("/api/food/delete").sessionAttrs(sessionattr))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
