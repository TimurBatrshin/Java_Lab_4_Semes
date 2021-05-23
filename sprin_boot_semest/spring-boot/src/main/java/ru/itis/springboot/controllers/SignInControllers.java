package ru.itis.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.springboot.dto.SignInForm;
import ru.itis.springboot.models.User;
import ru.itis.springboot.services.SignInService;

import javax.annotation.security.PermitAll;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class SignInControllers {
    @GetMapping("/sign_in")
    public String getSignInPage() {
        return "sign_in";
    }
}
