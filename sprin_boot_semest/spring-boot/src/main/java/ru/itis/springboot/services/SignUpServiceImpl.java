package ru.itis.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.springboot.dto.SignUpForm;
import ru.itis.springboot.models.User;
import ru.itis.springboot.repositories.UserRepository;
import ru.itis.springboot.util.EmailUtil;
import ru.itis.springboot.util.MailsGenerator;
//import ru.itis.springboot.util.EmailUtil;
//import ru.itis.springboot.util.MailsGenerator;

import java.util.UUID;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailsGenerator mailsGenerator;

    @Autowired
    private EmailUtil emailUtil;

    @Value("${server.url}")
    private String serverUrl;

    @Value("${spring.mail.username}")
    private String from;


    @Override
    public void signUp(SignUpForm signUpForm) {
        User newUser = User.builder()
                .first_name(signUpForm.getFirst_name())
                .last_name(signUpForm.getLast_name())
                .email(signUpForm.getEmail().trim())
                .hashPassword(passwordEncoder.encode(signUpForm.getPassword()))
                .confirmCode(UUID.randomUUID().toString())
                .role(User.Role.USER)
                .state(User.State.ACTIVE)
                .point(0L)
                .photoUrl("https://sun9-51.userapi.com/impf/c845122/v845122920/143e70/HfKoFsr7frw.jpg?size=810x1080&quality=96&sign=cf716fe4c5d65f7d1ef4612a190d396a&type=album")
                .city(signUpForm.getCity())
                .confirm(User.Confirm.NOT_CONFIRM)
                .nationality("Russia")
                .build();
        userRepository.save(newUser);

        String confirmMail = mailsGenerator.getMailForConfirm(serverUrl, newUser.getConfirmCode());

        emailUtil.sendMail(newUser.getEmail(), "Регистрация", from, confirmMail);
    }
}
