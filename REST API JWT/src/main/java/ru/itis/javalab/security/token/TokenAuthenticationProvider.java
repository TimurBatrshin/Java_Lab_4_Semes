package ru.itis.javalab.security.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ru.itis.javalab.security.details.UserDetailsServiceImpl;

@Component
public class TokenAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private Algorithm algorithm;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        TokenAuthentication tokenAuthentication = (TokenAuthentication)authentication;

        DecodedJWT jwt;

        try {
            jwt = JWT
                    .require(algorithm)
                    .build()
                    .verify(authentication.getName());

        } catch (JWTVerificationException e) {
            throw new BadCredentialsException("Bad token");
        }

        tokenAuthentication.setAuthenticated(true);
        tokenAuthentication.setAuthority(jwt.getClaim("role").asString());
        return tokenAuthentication;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return TokenAuthentication.class.equals(aClass);
    }
}
