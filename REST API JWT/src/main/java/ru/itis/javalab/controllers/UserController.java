package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.itis.javalab.dto.SignUpDto;
import ru.itis.javalab.services.SignUpService;

@Controller
public class UserController {

    @Autowired
    private SignUpService signUpService;


    @PostMapping("/sign_up")
    public ResponseEntity<SignUpDto> signUp(@RequestBody SignUpDto signUpDto) {
        return ResponseEntity.ok(signUpService.save(signUpDto));
    }
}
