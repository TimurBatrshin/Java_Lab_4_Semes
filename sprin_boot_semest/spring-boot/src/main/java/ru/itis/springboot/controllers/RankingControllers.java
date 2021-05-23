package ru.itis.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.springboot.models.User;
import ru.itis.springboot.services.UsersService;

import java.util.List;

@Controller
public class RankingControllers {

    @Autowired
    private UsersService usersService;

    @GetMapping("/ranking")
    public String getRankingPage(Model model){
        List<User> users = usersService.rankings();
        model.addAttribute("users", users);

        return "ranking";
    }
}
