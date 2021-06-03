package ru.itis.javalab.services;


import ru.itis.javalab.dto.SignUpDto;

public interface SignUpService {
    SignUpDto save(SignUpDto signUpDto);
}
