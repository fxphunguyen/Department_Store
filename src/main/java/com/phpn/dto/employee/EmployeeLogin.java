package com.phpn.dto.employee;

import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotBlank;

import lombok.experimental.Accessors;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class EmployeeLogin {

    @Size(min = 6, max = 50, message = "The length of email must be between 5 and 50 characters!")
    @Email(message = "The email address is invalid!")
    @NotBlank(message = "The email address is required!")
    private String email;

    @Size(min = 6, max = 32, message = "The length of password must be between 6 and 32 characters!")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{5,}$", message = "The password minimum 5 characters, at least one letter, one number and one special character!")
    @NotBlank(message = "The password is required!")
    private String password;

}