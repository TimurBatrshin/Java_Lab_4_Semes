package ru.itis.javalab.jwt.services;

import ru.itis.javalab.jwt.dto.LoginDto;
import ru.itis.javalab.jwt.models.User;

public interface LoginService {

    User login(LoginDto loginDto);

}
