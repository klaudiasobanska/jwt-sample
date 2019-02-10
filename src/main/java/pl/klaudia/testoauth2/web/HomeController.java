package pl.klaudia.testoauth2.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.klaudia.testoauth2.api.AbstractController;

@Controller
public class HomeController extends AbstractController {

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String home() {
        return "home";
    }

}
