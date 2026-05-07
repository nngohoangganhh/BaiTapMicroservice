package com.demo.iamservice.controller;

import com.demo.commonlib.response.ApiResponse;import com.demo.iamservice.dto.LoginRequest;
import com.demo.iamservice.dto.LoginResponse;
import com.demo.iamservice.sercurity.JwtService;
import com.demo.iamservice.service.AuthService;import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/iam/auth")
@RequiredArgsConstructor
public class AuthController {
     private final AuthService authService;

    @PostMapping("/login")
    public ApiResponse<LoginResponse> login(@RequestBody LoginRequest request) {
        return ApiResponse.<LoginResponse>builder()
                .success(true)
                .massage("Login suscess")
                .data(authService.login(request))
                .build();
    }
}