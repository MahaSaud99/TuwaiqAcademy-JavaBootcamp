package com.example.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;

@AllArgsConstructor
@Data
public class User {
    @NotEmpty(message = "Id must not be empty!")
    @Size(min = 3, message = "Id have to be 3 character long")
    private String id;

    @NotEmpty (message = "username must not be empty!")
    @Size(min = 5, message = "username have to be 5 character long")
    private String username;

    @NotEmpty (message = "Password must not be empty!")
    @Size(min = 6, message = "Password have to be 6 length long")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{6,30}$",message = "Please enter strong password")
    private String password;

    @NotEmpty(message = "Email must not be empty!")
    @Email(message = "Please enter a valid email")
    private String email;

    @NotEmpty(message = "Role must not be empty")
    @Pattern(regexp = "(admin|customer)",message = "Role must be in admin or customer only")
    private String role;

    @NotNull(message = "Balance must not be empty!")
    @Positive(message = "Balance must be positive number")
    private Integer balance;
}