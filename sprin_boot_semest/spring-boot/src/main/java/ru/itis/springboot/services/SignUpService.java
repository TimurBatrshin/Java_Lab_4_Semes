package ru.itis.springboot.services;


import ru.itis.springboot.dto.SignUpForm;

public interface SignUpService {
    void signUp(SignUpForm signUpForm);
}
