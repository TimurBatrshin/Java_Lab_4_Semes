package ru.itis.javalab.services;

import ru.itis.javalab.dto.EmailPasswordDto;
import ru.itis.javalab.dto.TokenDto;

public interface LoginService {
    TokenDto login(EmailPasswordDto emailPassword);
}
