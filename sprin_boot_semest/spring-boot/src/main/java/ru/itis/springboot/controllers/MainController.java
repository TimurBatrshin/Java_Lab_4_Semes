package ru.itis.springboot.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/main")
    public String getMainPage(Model model, Authentication authentication){
        model.addAttribute("authentication", authentication);
        return "main";
    }

}
