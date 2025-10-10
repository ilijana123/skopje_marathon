package com.example.skopje_marathon.service;

import com.example.skopje_marathon.dto.LoginRequest;
import com.example.skopje_marathon.dto.LoginResponse;
import com.example.skopje_marathon.model.Contestant;
import com.example.skopje_marathon.repository.ContestantRepository;
import com.example.skopje_marathon.util.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final ContestantRepository contestantRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public LoginService(
            ContestantRepository contestantRepository,
            PasswordEncoder passwordEncoder,
            JwtUtil jwtUtil
    ) {
        this.contestantRepository = contestantRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public LoginResponse login(LoginRequest request) {
        Contestant contestant = contestantRepository.findByEmail(request.getEmail());
        if (contestant == null) {
            throw new RuntimeException("Invalid email or password");
        }

        if (!passwordEncoder.matches(request.getPassword(), contestant.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        String token = jwtUtil.generateToken(contestant.getEmail());

        return new LoginResponse("Login successful", token);
    }
}
