package com.example.mongodbgridfs.controller;

import com.example.mongodbgridfs.model.User;
import com.example.mongodbgridfs.security.details.UserDetailsImpl;
import com.example.mongodbgridfs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class ProfileController {

    @Autowired
    private UserService usersService;

    @GetMapping("/profile")
    public String getProfilePage(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model, Authentication authentication){
        Long user_id = userDetails.getUser().getId();
        Optional<User> user = usersService.findUserById(user_id);
        model.addAttribute("user", user);
        return "profile";
    }

}