package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.javalab.models.User;
import ru.itis.javalab.services.UsersService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@Profile("dev")
public class ProfileFakeController {
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getProfilePage(HttpServletRequest request, Model model) {
        Optional<User> user = usersService.getUser(Long.valueOf(1));
        model.addAttribute("user", user);
        System.out.println(user);
        return "profile";
    }
}
