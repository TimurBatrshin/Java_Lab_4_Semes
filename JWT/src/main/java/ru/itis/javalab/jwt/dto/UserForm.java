package ru.itis.javalab.jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserForm {

    private String UserName;
    private String email;
    private String phone;
    private String password;
    private Timestamp data;


}
