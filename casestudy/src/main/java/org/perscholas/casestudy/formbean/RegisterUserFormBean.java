package org.perscholas.casestudy.formbean;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


@Getter
@Setter
public class RegisterUserFormBean {

    @Email(message="email must be a valid address ")
    private String email;

    @Length(min = 8, message = "Password must be at least 8 characters long.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "Password must contain at least one lowercase letter," +
            " one uppercase letter, and one digit")
    private String password;

    @NotEmpty(message = "Confirm password cannot be empty")
    private String confirmPassword;

    private String firstname;
    private String lastname;
    private String phone;
    private String city;
}


