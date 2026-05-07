package com.demo.iamservice.service;

import com.demo.iamservice.dto.LoginRequest;
import com.demo.iamservice.dto.LoginResponse;
import com.demo.iamservice.sercurity.JWTFilter;
import com.demo.iamservice.sercurity.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final JwtService jwtService;
    public LoginResponse login(LoginRequest request) {

        if (!"admin".equals(request.getUsername())
                || !"123456".equals(request.getPassword())) {

            throw new RuntimeException("Invalid username or password");
        }

        String token = jwtService.generateToken(request.getUsername());

        return new LoginResponse(token);
    }
}
