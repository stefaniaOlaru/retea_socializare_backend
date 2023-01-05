package com.laboratoris.retea_socializare_backend.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserLoginRequest {

    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
