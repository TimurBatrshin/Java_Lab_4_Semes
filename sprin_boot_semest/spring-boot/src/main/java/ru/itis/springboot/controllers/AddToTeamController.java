package ru.itis.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.springboot.models.Team;
import ru.itis.springboot.models.User;
import ru.itis.springboot.services.TeamService;
import ru.itis.springboot.services.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AddToTeamController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private TeamService teamService;

    @GetMapping("/add/{user_id}")
    public String getAddTeamController(Model model, @PathVariable Long user_id, HttpServletRequest request, Authentication authentication){
        HttpSession session = request.getSession();
        Long team_id = (Long) session.getAttribute("team_id");
        Long contest_id = (Long) session.getAttribute("contest_id");
        teamService.teamSaveUsers(team_id, user_id);
        teamService.teamSaveToContest(contest_id, team_id);
        List<Long> longList = teamService.findAllByTeam(team_id);
        List<User> userList = new ArrayList<>();
        for (Long id : longList) {
            Optional<User> user = usersService.findUserById(id);
            if (user.isPresent())
            userList.add(user.get());
        }
        model.addAttribute("userList", userList);
        model.addAttribute("authentication", authentication);

//        Optional<User> user = usersService.findUserById(user_id);
//        List<User> user = teamService.findAllByTeam(user_id, team_id);
//        List<User> user = usersService.selectTeam(user_id, team_id);

        return "YourTeam";
    }

    @GetMapping("/add")
    public String getTeamPage(Model model){
        List<User> userList = usersService.getAllUsers();
        model.addAttribute("userList", userList);
        return "addToTeam";

    }
//    @GetMapping("/add/get-by-title")
//    public ResponseEntity<List<User>> getAjaxPapers(@RequestParam(name = "template") String template) {
//        return ResponseEntity.ok(usersService.findUserByTemplate(template));
//    }

}
