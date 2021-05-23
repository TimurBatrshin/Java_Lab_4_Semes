package ru.itis.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.springboot.models.User;
import ru.itis.springboot.repositories.UserRepository;
import ru.itis.springboot.security.details.UserDetailsImpl;
import ru.itis.springboot.services.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class ProfileController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/profile")
    public String getProfilePage(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model){
        Long user_id = userDetails.getUser().getId();
        Optional<User> user = usersService.findUserById(user_id);
        model.addAttribute("user", user);
        return "profile";
    }

}