package ru.itis.javalab.services;

import com.auth0.jwt.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.javalab.dto.EmailPasswordDto;
import ru.itis.javalab.dto.TokenDto;
import ru.itis.javalab.models.Token;
import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.TokensRepository;
import ru.itis.javalab.repositories.UserRepository;
import com.auth0.jwt.algorithms.Algorithm;


import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {

    private User user;

    @Autowired
    private Algorithm algorithm;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokensRepository tokensRepository;

    @Override
    public TokenDto login(EmailPasswordDto emailPassword) {

        try {
            user=userRepository.findByEmail(emailPassword.getEmail());
        } catch (UsernameNotFoundException ex){
            throw new UsernameNotFoundException("User not found");
        }
        if (passwordEncoder.matches(emailPassword.getPassword(),user.getHashPassword())){
            String tokenValue = JWT.create()
                    .withSubject(user.getId().toString())
                    .withClaim("role", user.getRole().toString())
                    .withClaim("state", user.getState().toString())
                    .withClaim("email", user.getEmail())
                    .withClaim("createdAt", LocalDateTime.now().toString())
                    .sign(algorithm);
            Token token = Token.builder()
                    .token(tokenValue)
                    .user(user)
                    .build();
            tokensRepository.save(token);

            return TokenDto.builder()
                    .token(tokenValue)
                    .build();
        } else {
            throw new UsernameNotFoundException("Invalid user name or password");
        }
    }
}
