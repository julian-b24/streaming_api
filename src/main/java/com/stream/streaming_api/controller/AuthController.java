package com.stream.streaming_api.controller;

import com.stream.streaming_api.api.AuthAPI;
import com.stream.streaming_api.dto.JwtDTO;
import com.stream.streaming_api.dto.UserLoginDTO;
import com.stream.streaming_api.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthController implements AuthAPI {

    public final AuthService authService;

    @Override
    public JwtDTO loginUser(UserLoginDTO user) {
        return authService.loginUser(user);
    }

    @Override
    public JwtDTO refreshToken(JwtDTO token) {
        return authService.refreshToken(token);
    }

}
