package ru.itis.api.services;

import ru.itis.api.dto.SignUpDto;

public interface SignUpService {
    SignUpDto save(SignUpDto signUpDto);
}
