package ru.itis.javalab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.itis.javalab.dto.UserForm;
import ru.itis.javalab.models.User;
import ru.itis.javalab.util.MailsGenerator;

import java.util.UUID;

@Service
@Profile("dev")
public class SignUpFakeImpl implements SignUpService {

    @Autowired
    private MailsGenerator mailsGenerator;

    @Value("${server.url}")
    private String serverUrl;


    @Override
    public void signUp(UserForm userForm) {
        User newUser = User.builder()
                .first_name(userForm.getFirst_name())
                .last_name(userForm.getLast_name())
                .email(userForm.getEmail().trim())
                .password(userForm.getPassword().trim())
                .phone(userForm.getPhone())
                .confirmCode(UUID.randomUUID().toString())
                .build();

        String confirmMail = mailsGenerator.getMailForConfirm(serverUrl, newUser.getConfirmCode());
//        emailUtil.sendMail(newUser.getEmail(), "Регистрация", from, confirmMail);
        System.out.println(confirmMail);

        }
}
