package ru.itis.springboot.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.springboot.security.details.UserDetailsImpl;

import java.util.UUID;

@Controller
public class IndexController {
    @GetMapping("/index")
    public String getIndexPage(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("pageId", userDetails.getUser().getFirst_name());
        return "index";
    }
}

