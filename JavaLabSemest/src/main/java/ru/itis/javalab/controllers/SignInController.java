package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.javalab.models.User;
import ru.itis.javalab.services.BCrypterService;
import ru.itis.javalab.services.UsersService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class SignInController {
    @Autowired
    private UsersService usersService;

    @Autowired
    private BCrypterService bCrypterService;

    @RequestMapping(value = "/sign_in", method = RequestMethod.GET)
    public String getSignInPage() {
        return "/sign_in";
    }

    @RequestMapping(value = "/sign_in", method = RequestMethod.POST)
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email").trim();
        String password = request.getParameter("password").trim();
        Optional<User> user = usersService.findUserByEmail(email);
        if (user.isPresent() && bCrypterService.checkPassword(password, user.get().getPassword().trim())) {
//            System.out.println("Вошел");
            HttpSession session = request.getSession(true);
            session.setAttribute("email", user.get().getEmail());
            session.setAttribute("authenticated", true);
            Cookie cookie = new Cookie("email", email);
            cookie.setMaxAge(60 * 60 * 24 * 365);
            response.addCookie(cookie);
            return new ModelAndView("redirect:/main");
        } else {
//            System.out.println("Не вошел");
            return new ModelAndView("redirect:/sign_in");
        }
    }

}
