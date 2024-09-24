package com.stream.streaming_api.service.impl;

import com.stream.streaming_api.constants.StreamingErrorCode;
import com.stream.streaming_api.constants.TokenTime;
import com.stream.streaming_api.dto.JwtDTO;
import com.stream.streaming_api.dto.UserLoginDTO;
import com.stream.streaming_api.error.exception.StreamingError;
import com.stream.streaming_api.error.exception.StreamingException;
import com.stream.streaming_api.model.User;
import com.stream.streaming_api.repository.UserRepository;
import com.stream.streaming_api.service.AuthService;
import com.stream.streaming_api.utils.JWTParser;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    public final UserRepository userRepository;

    @Override
    public JwtDTO loginUser(UserLoginDTO user) {
        User userFound = userRepository.findByNickname(user.getNickname());
        if (userFound == null || !Objects.equals(userFound.getPassword(), user.getPassword())) {
            throw new StreamingException(HttpStatus.BAD_REQUEST, new StreamingError(StreamingErrorCode.CODE_400_LOGIN, StreamingErrorCode.CODE_400_LOGIN.getMessage()));
        }

        Map<String, String> claims = new HashMap<>();
        claims.put("nickname", userFound.getNickname());
        return new JwtDTO(JWTParser.createJWT(userFound.getId().toString(), user.getNickname(), user.getNickname(), claims, 15 * TokenTime.ONE_MINUTE.getTime()));
    }

    @Override
    public JwtDTO refreshToken(JwtDTO token) {
        return null;
    }

}
