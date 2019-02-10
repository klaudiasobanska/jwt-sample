package pl.klaudia.testoauth2.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.klaudia.testoauth2.api.AbstractController;

import javax.persistence.Column;

@Controller
public class LoginController extends AbstractController {


    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
