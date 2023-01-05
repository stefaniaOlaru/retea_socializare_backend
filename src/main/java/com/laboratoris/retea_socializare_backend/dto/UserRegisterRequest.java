package com.laboratoris.retea_socializare_backend.dto;

import com.laboratoris.retea_socializare_backend.model.Section;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Builder
public class UserRegisterRequest {

    @Email
    private String email;

    private String password;

    private Integer characterId;

    private Section section;
}
