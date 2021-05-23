package ru.itis.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.springboot.dto.SignUpForm;
import ru.itis.springboot.models.User;
import ru.itis.springboot.repositories.UserRepository;
//import ru.itis.springboot.util.EmailUtil;
//import ru.itis.springboot.util.MailsGenerator;

import java.util.UUID;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private MailsGenerator mailsGenerator;
//
//    @Autowired
//    private EmailUtil emailUtil;

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
                .photoUrl("/static/img/logo-white.jpg")
                .city(signUpForm.getCity())
                .build();
        userRepository.save(newUser);

//        String confirmMail = mailsGenerator.getMailForConfirm(serverUrl, newUser.getConfirmCode());
//
//        emailUtil.sendMail(newUser.getEmail(), "Регистрация", from, confirmMail);
    }
}
