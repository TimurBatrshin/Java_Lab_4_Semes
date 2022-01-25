package ru.itis.api.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.api.dto.EmailPasswordDto;
import ru.itis.api.dto.TokenDto;
import ru.itis.api.models.User;
import ru.itis.api.redis.services.RedisUsersService;
import ru.itis.api.repository.UsersRepository;

import java.util.function.Supplier;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private Algorithm algorithm;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RedisUsersService redisUsersService;

    @SneakyThrows
    @Override
    public TokenDto login(EmailPasswordDto emailPassword) {
        User user = usersRepository.findByEmail(emailPassword.getEmail())
                .orElseThrow((Supplier<Throwable>) () -> new UsernameNotFoundException("User not found"));
        if (passwordEncoder.matches(emailPassword.getPassword(), user.getHashPassword())) {
            String token = JWT.create()
                    .withSubject(user.getId().toString())
                    .withClaim("role", user.getRole().toString())
                    .withClaim("state", user.getState().toString())
                    .withClaim("email", user.getEmail())
                    .sign(algorithm);
            redisUsersService.addTokenToUser(user, token);
            return TokenDto.builder()
                    .token(token)
                    .build();
        } else {
            throw new UsernameNotFoundException("Invalid username or password");
        }
    }
}
