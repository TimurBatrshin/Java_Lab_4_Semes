package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.javalab.services.UsersService;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

//    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/users")
    public String getUsersPage(Model model) {
        model.addAttribute("usersList", usersService.getAllUsers());
        return "user_page";
    }

//    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/banAll")
    public String banUsers() {
        usersService.banAll();
        return "redirect:/users";
    }

}
