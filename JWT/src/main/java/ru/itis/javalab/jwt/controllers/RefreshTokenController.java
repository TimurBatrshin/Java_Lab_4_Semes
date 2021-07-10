package ru.itis.javalab.jwt.controllers;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.javalab.jwt.dto.TokenPairDto;
import ru.itis.javalab.jwt.dto.TokenRefreshDto;
import ru.itis.javalab.jwt.services.TokenService;

import javax.annotation.security.PermitAll;

@RestController
public class RefreshTokenController {

    @Autowired
    private TokenService tokenService;

    @PermitAll
    @GetMapping("/refresh_tokens")
    public ResponseEntity<?> refreshTokens(@RequestBody TokenRefreshDto tokenPair) {
        try {
            TokenPairDto tokenPairDto = tokenService.refreshToken(tokenPair);
            return ResponseEntity.ok(tokenPairDto);
        } catch (Exception e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("status", e.getMessage());
            return new ResponseEntity<>(jsonObject, HttpStatus.BAD_REQUEST);
        }
    }

}
