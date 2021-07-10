package ru.itis.javalab.jwt.controllers;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.javalab.jwt.dto.LoginDto;
import ru.itis.javalab.jwt.dto.TokenPairDto;
import ru.itis.javalab.jwt.models.User;
import ru.itis.javalab.jwt.services.LoginService;
import ru.itis.javalab.jwt.services.TokenService;

import javax.annotation.security.PermitAll;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private TokenService tokenService;

    @PermitAll
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        try {
            User user = loginService.login(loginDto);
            TokenPairDto tokenDto = tokenService
                    .generateTokenPair(user, loginDto.getDeviceFingerprint());
            return ResponseEntity.ok(tokenDto);
        } catch (UsernameNotFoundException e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("status", e.getMessage());
            return new ResponseEntity<>(jsonObject, HttpStatus.BAD_REQUEST);
        }
    }

}
