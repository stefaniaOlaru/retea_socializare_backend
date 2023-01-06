package com.laboratoris.retea_socializare_backend.service;

import com.laboratoris.retea_socializare_backend.dto.JwtResponse;
import com.laboratoris.retea_socializare_backend.dto.UserLoginRequest;
import com.laboratoris.retea_socializare_backend.dto.UserRegisterRequest;
import org.springframework.http.ResponseEntity;

public interface IAuthService {

    public ResponseEntity<JwtResponse> login(UserLoginRequest request);

    public ResponseEntity<JwtResponse> create(UserRegisterRequest request) throws Exception;

    public ResponseEntity<JwtResponse> refresh(String refreshToken);
}
