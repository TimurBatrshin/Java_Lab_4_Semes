package ru.itis.javalab.jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenRefreshDto {

    private String accessToken;
    private String refreshToken;
    private String deviceFingerprint;

}
