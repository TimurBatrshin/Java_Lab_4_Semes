package ru.itis.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.springboot.models.Team;
import ru.itis.springboot.models.User;
import ru.itis.springboot.security.details.UserDetailsImpl;
import ru.itis.springboot.services.TeamService;
import ru.itis.springboot.services.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class MyTeamController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private UsersService usersService;

    @GetMapping("/myTeam")
    public String getMyTeamPage(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails, HttpServletRequest request){
        HttpSession session = request.getSession();
        Long team_id = (Long) session.getAttribute("team_id");
        List<Long> longList = teamService.findAllByTeam(team_id);
        List<User> userList = new ArrayList<>();
        for (Long id : longList) {
            Optional<User> user = usersService.findUserById(id);
            if (user.isPresent())
                userList.add(user.get());
        }
        model.addAttribute("userList", userList);


        User user = userDetails.getUser();
//        Long user_id = user.getId();
//        Optional<User> users = usersService.findUserById(user_id);
//        users.get().getTeams();
        user.getTeams();

        return "myTeam";
    }

}
