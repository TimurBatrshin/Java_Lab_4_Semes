package ru.itis.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.springboot.models.Team;
import ru.itis.springboot.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String email;
    private String first_name;
    private String last_name;
    private String point;
    private int rang;
    private List<String> teams;

    public static UserDto from(User user) {
        UserDto userDto = UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .first_name(user.getFirst_name())
                .last_name(user.getLast_name())
                .build();
         if ((user.getTeams() != null)) {
            userDto.setTeams(user.getTeams().stream().map(Team::getName).collect(Collectors.toList()));
         }
         return userDto;
    }

//    public static List<UserDto> from(List<User> users) {
//        return users.stream().map(UserDto::from).collect(Collectors.toList());
//    }
    public static List<UserDto> from(List<User> users) {
        return users.stream().map(UserDto::from).collect(Collectors.toList());
    }
}

