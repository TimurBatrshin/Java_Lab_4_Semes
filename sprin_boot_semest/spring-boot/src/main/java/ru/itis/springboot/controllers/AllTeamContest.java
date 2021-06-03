package ru.itis.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.springboot.models.Team;
import ru.itis.springboot.services.TeamService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class AllTeamContest {

    @Autowired
    private TeamService teamService;

    @GetMapping("/allTeams")
    public String getAllTeamContest(Model model, HttpServletRequest request, Authentication authentication) {
        HttpSession session = request.getSession();
        Long contest_id = (Long) session.getAttribute("contest_id");
        Optional<Team> teams = teamService.findTeamByContest(contest_id);
        model.addAttribute("teams", teams);
        model.addAttribute("authentication", authentication);
        return "teamContest";
    }

}
