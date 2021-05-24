package ru.itis.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.springboot.models.User;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersDto {
    private Long id;
    private String email;
    private String first_name;
    private String last_name;

    public static UsersDto from(User user) {
        return UsersDto.builder()
                .id(user.getId())
                .email(user.getEmail())

                .build();
    }

    public static List<UsersDto> from(List<User> users) {
        return users.stream()
                .map(UsersDto::from)
                .collect(Collectors.toList());
    }
}
