package ru.itis.javalab.jwt.services;

import com.auth0.jwt.interfaces.Claim;
import ru.itis.javalab.jwt.dto.TokenPairDto;
import ru.itis.javalab.jwt.dto.TokenRefreshDto;
import ru.itis.javalab.jwt.models.RefreshToken;
import ru.itis.javalab.jwt.models.User;

import java.util.Map;

public interface TokenService {

    String generateAccessToken(User user);

    RefreshToken generateRefreshToken(User user, String fingerprint);

    Map<String, Claim> verifyToken(String token);

    boolean validateToken(String token);

    TokenPairDto refreshToken(TokenRefreshDto tokenPair);

    Map<String, Claim> getClaims(String token);

    public TokenPairDto generateTokenPair(User user, String fingerprint);

}
