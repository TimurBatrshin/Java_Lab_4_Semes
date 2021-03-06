package ru.itis.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.springboot.dto.TeamDto;
import ru.itis.springboot.models.Team;
import ru.itis.springboot.services.TeamService;
import ru.itis.springboot.services.UsersService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CreateTeamController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private TeamService teamService;

    @GetMapping("/createTeam")
    private String getCreateTeamPage() {
        return "createTeam";
    }

    @PostMapping("/createTeam")
    private String getCreateTeamPagePost(TeamDto teamDto, HttpServletRequest request, Authentication authentication, Model model) {
        Team team = teamService.save(teamDto);
        HttpSession session = request.getSession(true);
        session.setAttribute("team_id", team.getId());
        Cookie cookie = new Cookie("team_id",team.getId().toString());
        cookie.setMaxAge(60*60*24*365);
        model.addAttribute("authentication", authentication);
        return "redirect:/add";
    }

}
