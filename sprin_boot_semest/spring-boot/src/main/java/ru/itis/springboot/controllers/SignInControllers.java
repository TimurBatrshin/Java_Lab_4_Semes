package ru.itis.springboot.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInControllers {
    @GetMapping("/sign_in")
    public String getSignInPage(Model model, Authentication authentication) {
        model.addAttribute("authentication", authentication);
        return "sign_in";
    }
}
