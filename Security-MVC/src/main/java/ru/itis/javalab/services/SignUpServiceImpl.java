package ru.itis.javalab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.javalab.dto.UserForm;
import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.UsersRepository;

@Service
public class SignUpServiceImpl implements SignUpService {

        @Autowired
        private UsersRepository usersRepository;

        @Autowired
        private PasswordEncoder passwordEncoder;

        @Override
        public void signUp(UserForm form) {
            User newUser = User.builder()
                    .email(form.getEmail())
                    .hashPassword(passwordEncoder.encode(form.getPassword()))
                    .role(User.Role.USER)
                    .state(User.State.ACTIVE)
                    .build();

            usersRepository.save(newUser);
        }


}
