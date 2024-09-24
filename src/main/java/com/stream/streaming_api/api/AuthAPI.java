package com.stream.streaming_api.api;

import com.stream.streaming_api.dto.JwtDTO;
import com.stream.streaming_api.dto.UserLoginDTO;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/auth")
public interface AuthAPI {

    @PostMapping("/login")
    JwtDTO loginUser(@RequestBody UserLoginDTO user);

    @PostMapping("/refresh-token")
    JwtDTO refreshToken(@RequestBody JwtDTO token);

}
