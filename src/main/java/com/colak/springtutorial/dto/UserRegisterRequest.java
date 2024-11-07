package com.colak.springtutorial.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest {
    @NotNull(message = "username cannot be null")
    @NotEmpty(message = "username cannot be blank")
    private String username;

    private String email;

    private String password;
}
