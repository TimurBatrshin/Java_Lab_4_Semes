package ru.itis.javalab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.itis.javalab.dto.UserForm;
import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.UsersRepository;
import ru.itis.javalab.util.EmailUtil;
import ru.itis.javalab.util.MailsGenerator;


import java.util.UUID;

@Service
@Profile("master")
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private MailsGenerator mailsGenerator;

    @Autowired
    private EmailUtil emailUtil;

    @Value("${server.url}")
    private String serverUrl;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void signUp(UserForm userForm) {
        User newUser = User.builder()
                .first_name(userForm.getFirst_name())
                .last_name(userForm.getLast_name())
                .email(userForm.getEmail().trim())
                .password(userForm.getPassword().trim())
                .phone(userForm.getPhone())
                .confirmCode(UUID.randomUUID().toString())
                .role(User.Role.USER)
                .state(User.State.ACTIVE)
                .build();
        usersRepository.save(newUser);

        String confirmMail = mailsGenerator.getMailForConfirm(serverUrl, newUser.getConfirmCode());
        emailUtil.sendMail(newUser.getEmail(), "Регистрация", from, confirmMail);
    }
}
