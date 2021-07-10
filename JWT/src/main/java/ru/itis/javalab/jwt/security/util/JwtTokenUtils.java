package ru.itis.javalab.jwt.security.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenUtils {

    public static String SECRET_KEY;

    public static final String ROLE = "role";

    public static final String EMAIL = "email";

    public static final String STATE = "state";

    public static final String ID = "id";

    public static Long ACCESS_TOKEN_LIFE_TIME = 1000 * 60 * 30L;

    public static Long REFRESH_TOKEN_LIFE_TIME = 1000 * 60 * 24 * 60L;

    @Value("${jwt.access.lifetime}")
    public void setAccessTokenLifeTime(Long accessTokenLifeTime) {
        ACCESS_TOKEN_LIFE_TIME = accessTokenLifeTime;
    }

    @Value("${jwt.refresh.lifetime}")
    public void setRefreshTokenLifeTime(Long refreshTokenLifeTime) {
        REFRESH_TOKEN_LIFE_TIME = refreshTokenLifeTime;
    }

    @Value("${jwt.secret.key}")
    public void setSecretKey(String secretKey) {
        SECRET_KEY = secretKey;
    }

}
