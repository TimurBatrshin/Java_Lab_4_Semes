package ru.itis.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.api.dto.EmailPasswordDto;
import ru.itis.api.dto.SignUpDto;
import ru.itis.api.dto.TokenDto;
import ru.itis.api.models.User;
import ru.itis.api.services.LoginService;
import ru.itis.api.services.SignUpService;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private SignUpService signUpService;

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody EmailPasswordDto emailPassword) {
        return ResponseEntity.ok(loginService.login(emailPassword));
    }

    @PostMapping("/sign_up")
    public ResponseEntity<User> signUp(@RequestBody SignUpDto signUpDto) {
         return ResponseEntity.ok(signUpService.save(signUpDto));
    }
}
