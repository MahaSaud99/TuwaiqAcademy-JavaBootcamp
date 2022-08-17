package com.example.javaw3d4.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class loginForm {
    @NotEmpty(message = "Username must not be empty!")
    private String username;
    @NotEmpty(message = "Password must not be empty!")
    private String password;
}
