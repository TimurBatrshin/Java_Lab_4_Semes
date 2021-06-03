package ru.itis.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.springboot.models.User;
import ru.itis.springboot.security.details.UserDetailsImpl;
import ru.itis.springboot.services.UsersService;

import java.util.Locale;
import java.util.Optional;

@Controller
public class SuccessController {

    @Value("${server.url}")
    private String serverUrl;

    @Autowired
    private UsersService usersService;

    @GetMapping("${server.url}/confirm/{confirm_code}")
    public String getSuccessPage(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable String confirm_code) {
        Long user_id = userDetails.getUser().getId();
        Optional<User> user = usersService.findUserById(user_id);
        if (user.get().getConfirmCode() == confirm_code) {
            usersService.Success(user_id);
            return "succes";
        }
        else return "Nosuccess";
    }

}
