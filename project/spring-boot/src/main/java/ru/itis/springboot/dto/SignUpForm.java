package ru.itis.springboot.dto;

import lombok.Data;
import ru.itis.springboot.validation.ValidNames;
import ru.itis.springboot.validation.ValidPassword;

import javax.validation.constraints.Email;

@Data
@ValidNames(
        message = "{errors.invalid.names}",
        name = "first_name",
        surname = "last_name"
)
public class SignUpForm {

    private String first_name;
    private String last_name;
    @Email(message = "{errors.incorrect.email}")
    private String email;
    @ValidPassword(message = "{errors.invalid.password}")
    private String password;

}
