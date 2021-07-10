package ru.itis.javalab.jwt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.javalab.jwt.dto.UserForm;
import ru.itis.javalab.jwt.models.User;
import ru.itis.javalab.jwt.services.SignUpService;

import javax.annotation.security.PermitAll;

@RestController
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @PermitAll
    @PostMapping("/sign_up")
    public ResponseEntity<?> signUp(@RequestBody UserForm userForm) {
        User user = signUpService.signUp(userForm);
        return ResponseEntity.ok(user);
    }
}
