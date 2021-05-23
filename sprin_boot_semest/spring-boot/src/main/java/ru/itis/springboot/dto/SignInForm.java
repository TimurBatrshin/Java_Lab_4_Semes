package ru.itis.springboot.dto;

import lombok.Data;

@Data
public class SignInForm {
    private String email;
    private String password;
}
