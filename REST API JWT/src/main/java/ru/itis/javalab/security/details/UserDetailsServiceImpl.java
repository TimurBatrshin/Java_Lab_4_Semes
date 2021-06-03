package ru.itis.javalab.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.itis.javalab.models.Token;
import ru.itis.javalab.repositories.TokensRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private TokensRepository tokensRepository;

    @Override
    public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {
        Token result;
        try {
            result = tokensRepository.findByToken(token);
        } catch (UsernameNotFoundException ex) {
            throw new UsernameNotFoundException("user not found");
        }
        return new UserDetailsImpl(result.getUser());

    }
}
