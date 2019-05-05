package project.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class FitProjectController {

    @RequestMapping(value = "/helloworld", method = RequestMethod.GET)
    public String helloWorld(){
        return "helloworld";
    }
}
