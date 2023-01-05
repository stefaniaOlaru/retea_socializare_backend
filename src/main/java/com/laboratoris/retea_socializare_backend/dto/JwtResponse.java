package com.laboratoris.retea_socializare_backend.dto;

import com.laboratoris.retea_socializare_backend.model.ERole;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {
    private String accessToken;
    private String refreshToken;
    private ERole role;
}
