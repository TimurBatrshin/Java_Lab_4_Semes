package ru.itis.javalab.jwt.security.provider;

import com.auth0.jwt.interfaces.Claim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import ru.itis.javalab.jwt.models.User;
import ru.itis.javalab.jwt.security.authentication.JwtAuthentication;
import ru.itis.javalab.jwt.security.details.UserDetailsImpl;
import ru.itis.javalab.jwt.security.util.JwtTokenUtils;
import ru.itis.javalab.jwt.services.TokenService;

import java.util.Map;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    public TokenService tokenService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String token = authentication.getName();
        Map<String, Claim> claims = tokenService.verifyToken(token);

        JwtAuthentication jwtAuthentication = new JwtAuthentication(token);

        if (claims != null) {
            User user = User.builder()
                    .email(claims.get(JwtTokenUtils.EMAIL).asString())
                    .state(claims.get(JwtTokenUtils.STATE).as(User.State.class))
                    .role(claims.get(JwtTokenUtils.ROLE).as(User.Role.class))
                    .id(claims.get(JwtTokenUtils.ID).asLong())
                    .build();
            jwtAuthentication.setAuthenticated(true);
            jwtAuthentication.setUserDetails(new UserDetailsImpl(user));
        } else {
            jwtAuthentication.setAuthenticated(false);
        }
        return jwtAuthentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthentication.class.equals(authentication);
    }
}
