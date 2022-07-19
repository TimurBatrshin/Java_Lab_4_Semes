package com.example.mongodbgridfs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInControllers {
    @GetMapping("/sign_in")
    public String getSignInPage() {
        return "sign_in";
    }
}
