package ru.itis.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.springboot.dto.SignUpForm;
import ru.itis.springboot.services.SignUpService;

import javax.validation.Valid;
import java.util.Objects;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @GetMapping("/sign_up")
    public String getSignUpPage(Authentication authentication, Model model) {
        model.addAttribute("authentication", authentication);
        model.addAttribute("signUpForm", new SignUpForm());
        return "signUp";
    }

//    @PostMapping("/sign_up")
//    public String signUp(SignUpForm signUpForm) {
//        signUpService.save(signUpForm);
//        return "redirect:/sign_in";
//    }


    @PostMapping("/sign_up")
    public String signUp(@Valid SignUpForm signUpForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().stream().anyMatch(error -> {
                if (Objects.requireNonNull(error.getCodes())[0].equals("signUpForm.ValidNames")) {
                    model.addAttribute("namesErrorMessage", error.getDefaultMessage());
                }
                return true;
            });
            model.addAttribute("signUpForm", signUpForm);
            return "signUp";
        }
        signUpService.save(signUpForm);
        return "redirect:/sign_in";
    }
}

