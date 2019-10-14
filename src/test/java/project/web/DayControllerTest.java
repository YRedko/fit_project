package project.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import project.domain.Day;
import project.domain.User;
import project.service.DayService;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = DayController.class)
@ContextConfiguration(classes = {Day.class, ExceptionController.class, DayController.class})
public class DayControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DayController dayController;

    @MockBean
    private DayService dayService;

    @Test
    public void ownDays() throws Exception {
        Map<String, Object> sessionattr = new HashMap<>();
        sessionattr.put("user", new User());

        mockMvc.perform(get("/api/day/own").sessionAttrs(sessionattr))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void allDays() throws Exception {
        Map<String, Object> sessionattr = new HashMap<>();
        sessionattr.put("user", new User());

        mockMvc.perform(get("/api/day/all").sessionAttrs(sessionattr))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void dayByDate() throws Exception {
        Map<String, Object> sessionattr = new HashMap<>();
        sessionattr.put("user", new User());

        mockMvc.perform(get("/api/day/own_by_date").sessionAttrs(sessionattr))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
