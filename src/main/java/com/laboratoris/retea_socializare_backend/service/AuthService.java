package com.laboratoris.retea_socializare_backend.service;

import com.laboratoris.retea_socializare_backend.dto.JwtResponse;
import com.laboratoris.retea_socializare_backend.dto.UserLoginRequest;
import com.laboratoris.retea_socializare_backend.dto.UserRegisterRequest;
import com.laboratoris.retea_socializare_backend.model.Character;
import com.laboratoris.retea_socializare_backend.model.ERole;
import com.laboratoris.retea_socializare_backend.model.User;
import com.laboratoris.retea_socializare_backend.repository.UserRepository;
import com.laboratoris.retea_socializare_backend.security.jwt.JwtTokenUtil;
import com.laboratoris.retea_socializare_backend.security.services.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Date;

@Service
@AllArgsConstructor
public class AuthService implements IAuthService {
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl myUserDetailsService;
    private final UserRepository applicationUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CharacterService characterService;

    @Override
    public ResponseEntity<JwtResponse> login(UserLoginRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(),
                            request.getPassword()));
            final UserDetails userDetails = myUserDetailsService.loadUserByUsername(
                    request.getEmail());
            final String token = jwtTokenUtil.generateAccessToken(userDetails.getUsername(),
                    Date.from(ZonedDateTime.now()
                            .plusMinutes(6000)
                            .toInstant()));
            final String refreshToken = jwtTokenUtil.generateAccessToken(userDetails.getUsername(),
                    Date.from(ZonedDateTime.now()
                            .plusDays(7)
                            .toInstant()));
            return ResponseEntity.ok()
                    .body(new JwtResponse(token, refreshToken,
                            applicationUserRepository.findByEmail(userDetails.getUsername())
                                    .orElse(null).getRole()));
        } catch (BadCredentialsException ex) {
            throw new BadCredentialsException("Bad credentials");
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public ResponseEntity<JwtResponse> create(UserRegisterRequest request) throws Exception {
        if (applicationUserRepository.findByEmail(request.getEmail()).orElse(null) != null) {
            throw new BadCredentialsException("User already exists");
        }

        request.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));

        Character character = characterService.findById(request.getCharacterId());

        User user = new User(request.getEmail(), request.getPassword(), request.getSection(),
                character,
                ERole.USER);

        user = applicationUserRepository.save(user);

        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(request.getEmail());
        final String token = jwtTokenUtil.generateAccessToken(userDetails.getUsername(),
                Date.from(ZonedDateTime.now()
                        .plusMinutes(6000)
                        .toInstant()));
        final String refreshToken = jwtTokenUtil.generateAccessToken(userDetails.getUsername(),
                Date.from(ZonedDateTime.now()
                        .plusDays(7)
                        .toInstant()));

        return ResponseEntity.ok()
                .body(new JwtResponse(token, refreshToken,
                        applicationUserRepository.findByEmail(userDetails.getUsername())
                                .orElse(null).getRole()));

    }

    @Override
    public ResponseEntity<JwtResponse> refresh(String refreshToken) {
        String email = jwtTokenUtil.getUsername(refreshToken);
        String token = jwtTokenUtil.generateAccessToken(email, Date.from(ZonedDateTime.now()
                .plusMinutes(6000)
                .toInstant()));
        JwtResponse jwtResponse = new JwtResponse(token, refreshToken,
                applicationUserRepository.findByEmail(email).orElse(null).getRole());
        return ResponseEntity.ok()
                .body(jwtResponse);
    }
}
