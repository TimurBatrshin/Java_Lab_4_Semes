package ru.itis.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.springboot.models.User;
import ru.itis.springboot.security.details.UserDetailsImpl;
import ru.itis.springboot.services.UserService;

import javax.persistence.ManyToMany;
import java.util.Optional;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String getProfilePage(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        Long user_id = userDetails.getUser().getId();
        Optional<User> user = userService.findById(user_id);
        model.addAttribute("user", user);
        return "profile";
    }

}
