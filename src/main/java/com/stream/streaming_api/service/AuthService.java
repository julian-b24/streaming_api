package com.stream.streaming_api.service;

import com.stream.streaming_api.dto.JwtDTO;
import com.stream.streaming_api.dto.UserLoginDTO;

public interface AuthService {

    JwtDTO loginUser(UserLoginDTO user);

    JwtDTO refreshToken(JwtDTO token);

}
