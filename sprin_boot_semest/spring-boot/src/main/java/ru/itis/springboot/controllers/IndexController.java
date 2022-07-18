package ru.itis.springboot.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.springboot.security.details.UserDetailsImpl;

@Controller
public class IndexController {
    @GetMapping("/index")
    public String getIndexPage(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails, Authentication authentication) {
        model.addAttribute("pageId", userDetails.getUser().getFirst_name());
        model.addAttribute("authentication", authentication);
        return "index";
    }
}

