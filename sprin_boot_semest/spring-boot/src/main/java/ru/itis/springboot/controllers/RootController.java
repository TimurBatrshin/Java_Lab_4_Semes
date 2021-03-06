package ru.itis.springboot.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.springboot.security.details.UserDetailsImpl;

@Controller
@RequestMapping("/")
public class RootController {
    @GetMapping
    public String getRoot(@AuthenticationPrincipal UserDetailsImpl userDetails, Authentication authentication){
        if (authentication != null){
            return "redirect:/profile";
        } else {
            return "redirect:/sign_in";
        }
    }
}
