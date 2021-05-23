package ru.itis.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.springboot.models.User;
import ru.itis.springboot.services.UsersService;

import java.util.List;

@Controller
public class UsersControllers {

    @Autowired
    private UsersService usersService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/users")
    public String getUsersPage(Model model) {
        List<User> users = usersService.getAllUsers();
        model.addAttribute("users", users);
        return "users_page";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/banAll")
    public String banUsers() {
        usersService.banAll();
        return "redirect:/users";
    }
}
