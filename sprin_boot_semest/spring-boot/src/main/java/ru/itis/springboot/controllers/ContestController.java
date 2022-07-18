package ru.itis.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.springboot.models.Contests;
import ru.itis.springboot.services.ContestService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class ContestController {


    @Autowired
    private ContestService contestService;

    @GetMapping("/contest/{contest_id}")
    public String getOneContestPage(Model model, @PathVariable Long contest_id, HttpServletRequest request, Authentication authentication) {
        Optional<Contests> contestsList = contestService.findById(contest_id);
        HttpSession session = request.getSession(true);
        session.setAttribute("contest_id", contest_id);
        Cookie cookie = new Cookie("contest_id",contestsList.get().getId().toString());
        cookie.setMaxAge(60*60*24*365);
        model.addAttribute("contestsList", contestsList);
        model.addAttribute("authentication", authentication);
        return "oneContest";
    }

}
