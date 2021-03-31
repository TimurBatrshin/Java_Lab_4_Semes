package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.javalab.models.User;
import ru.itis.javalab.services.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class ProfileController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getProfilePage(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        System.out.println(email);
        if (email != null) {
            Optional<User> user = usersService.findUserByEmail(email);
            model.addAttribute("user", user);
            System.out.println(user.get().getEmail());

        }
        return "profile";
    }

}