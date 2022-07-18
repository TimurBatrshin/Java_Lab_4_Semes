package ru.itis.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.springboot.models.User;
import ru.itis.springboot.security.details.UserDetailsImpl;
import ru.itis.springboot.services.UsersService;

import java.util.Optional;

@Controller
public class ProfileController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/profile")
    public String getProfilePage(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model, Authentication authentication){
        Long user_id = userDetails.getUser().getId();
        Optional<User> user = usersService.findUserById(user_id);
        model.addAttribute("user", user);
        model.addAttribute("authentication", authentication);
        return "profile";
    }

}