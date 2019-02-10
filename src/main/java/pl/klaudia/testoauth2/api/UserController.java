package pl.klaudia.testoauth2.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.klaudia.testoauth2.model.AUser;
import pl.klaudia.testoauth2.security.CurrentUser;
import pl.klaudia.testoauth2.security.UserPrincipal;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/user/me")
    public AUser getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        AUser userSummary = new AUser();
        userSummary.setUsername(currentUser.getUsername());
        userSummary.setId(currentUser.getId());
        return userSummary;
    }
}
