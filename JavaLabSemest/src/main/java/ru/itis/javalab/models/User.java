package ru.itis.javalab.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private String password;
    private Long cartId;

    private String state;

    private String confirmCode;

    public enum State{
        CONFIRMED, NOT_CONFIRMED
    }
}
