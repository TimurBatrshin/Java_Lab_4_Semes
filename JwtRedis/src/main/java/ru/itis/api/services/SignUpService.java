package ru.itis.api.services;

import ru.itis.api.dto.SignUpDto;
import ru.itis.api.models.User;

public interface SignUpService {
    User save(SignUpDto signUpDto);
}
