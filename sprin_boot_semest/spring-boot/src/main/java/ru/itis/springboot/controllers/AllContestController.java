package ru.itis.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.springboot.models.Contests;
import ru.itis.springboot.services.ContestService;

import java.util.List;

@Controller
public class AllContestController {

    @Autowired
    private ContestService contestService;

    @GetMapping("/contest")
    public String getContestPage(Model model) {
        List<Contests> contests = contestService.findAll();
        model.addAttribute("contests", contests);
        return "contests";
    }



}
