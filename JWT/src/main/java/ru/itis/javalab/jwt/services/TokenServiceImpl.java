package ru.itis.javalab.jwt.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.javalab.jwt.dto.TokenPairDto;
import ru.itis.javalab.jwt.dto.TokenRefreshDto;
import ru.itis.javalab.jwt.models.RefreshToken;
import ru.itis.javalab.jwt.models.User;
import ru.itis.javalab.jwt.repositories.TokenRepository;
import ru.itis.javalab.jwt.repositories.UsersRepository;
import ru.itis.javalab.jwt.security.util.JwtTokenUtils;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public String generateAccessToken(User user) {
        return JWT.create()
                .withSubject(user.getId().toString())
                .withClaim(JwtTokenUtils.ROLE, user.getRole().toString())
                .withClaim(JwtTokenUtils.STATE, user.getState().toString())
                .withClaim(JwtTokenUtils.EMAIL, user.getEmail())
                .withClaim(JwtTokenUtils.ID, user.getId())
                .withIssuedAt(new Date())
                .withExpiresAt(
                        new Date(System.currentTimeMillis() + JwtTokenUtils.ACCESS_TOKEN_LIFE_TIME))
                .sign(Algorithm.HMAC256(JwtTokenUtils.SECRET_KEY));
    }

    @Override
    public RefreshToken generateRefreshToken(User user, String fingerprint) {
        String refreshTokenToken = UUID.randomUUID().toString();
        RefreshToken refreshToken = RefreshToken.builder()
                .user_id(user.getId())
                .fingerprint(fingerprint)
                .token(refreshTokenToken)
                .issuedAt(new Date())
                .expiresAt(
                        new Date(System.currentTimeMillis() + JwtTokenUtils.REFRESH_TOKEN_LIFE_TIME))
                .build();

        tokenRepository.save(refreshToken);
        return refreshToken;
    }

    @Override
    public Map<String, Claim> verifyToken(String token) {
        try {
            DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(JwtTokenUtils.SECRET_KEY))
                    .build().verify(token);
            return decodedJWT.getExpiresAt()
                    .after(new Date()) ? decodedJWT.getClaims() : null;
        } catch (JWTVerificationException e) {
            return null;
        }
    }

    @Override
    public boolean validateToken(String token) {
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(JwtTokenUtils.SECRET_KEY))
                .build().verify(token);
        return !decodedJWT.getExpiresAt()
                .after(new Date());
    }

    @Override
    public TokenPairDto refreshToken(TokenRefreshDto tokenPair) {
        RefreshToken refreshToken = tokenRepository.findByToken(tokenPair.getRefreshToken()).orElseThrow(IllegalAccessError::new);

        Map<String, Claim> claims = getClaims(tokenPair.getAccessToken());

        User user = usersRepository.findById(claims.get(JwtTokenUtils.ID).asLong()).orElseThrow(IllegalAccessError::new);
        String newAccessToken = generateAccessToken(user);
        String newRefreshToken = UUID.randomUUID().toString();

        refreshToken.setToken(newRefreshToken);
        refreshToken.setIssuedAt(new Date());
        refreshToken.setExpiresAt(
                new Date(System.currentTimeMillis() + JwtTokenUtils.REFRESH_TOKEN_LIFE_TIME));

        tokenRepository.save(refreshToken);

        return TokenPairDto.builder()
                .refreshToken(newRefreshToken)
                .accessToken(newAccessToken)
                .build();
    }

    @Override
    public Map<String, Claim> getClaims(String token) {
        try {
            return JWT.require(Algorithm.HMAC256(JwtTokenUtils.SECRET_KEY))
                    .build().verify(token).getClaims();
        } catch (JWTVerificationException e) {
            return null;
        }
    }

    @Override
    public TokenPairDto generateTokenPair(User user, String fingerprint) {
        String accessToken = generateAccessToken(user);
        String refreshToken = generateRefreshToken(user, fingerprint).getToken();
        return new TokenPairDto(accessToken, refreshToken);
    }

}
