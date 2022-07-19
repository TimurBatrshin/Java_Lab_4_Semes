package com.example.mongodbgridfs.controller;

import com.example.mongodbgridfs.dto.SignUpForm;
import com.example.mongodbgridfs.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.security.PermitAll;

@Controller
public class SignUpControllers {

    @Autowired
    private SignUpService signUpService;

    @GetMapping("/sign_up")
    @PermitAll
    public String getSignUpPage() {
        return "sign_up";
    }

    @PostMapping("/sign_up")
    @PermitAll
    public String signUp(SignUpForm signUpForm) {
        System.out.println("gtt");
        signUpService.signUp(signUpForm);
        return "redirect:/sign_in";
    }
}
