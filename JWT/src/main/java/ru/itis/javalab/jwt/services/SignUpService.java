package ru.itis.javalab.jwt.services;

import ru.itis.javalab.jwt.dto.UserForm;
import ru.itis.javalab.jwt.models.User;

public interface SignUpService {

    User signUp(UserForm userForm);

}
