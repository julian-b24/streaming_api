package com.stream.streaming_api.api;

import com.stream.streaming_api.dto.JwtDTO;
import com.stream.streaming_api.dto.UserLoginDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/auth")
@Tag(name = "Authentication", description = "API for user authentication and JWT token management")
public interface AuthAPI {

    @Operation(summary = "Login an user", description = "Authenticates a user and return a JWT token")
    @PostMapping("/login")
    JwtDTO loginUser(
            @Parameter(description = "User login credentials") @RequestBody UserLoginDTO user
    );

}