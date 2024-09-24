package com.stream.streaming_api.service.impl;

import com.stream.streaming_api.constants.StreamingErrorCode;
import com.stream.streaming_api.error.exception.StreamingError;
import com.stream.streaming_api.error.exception.StreamingException;
import com.stream.streaming_api.model.User;
import com.stream.streaming_api.repository.UserRepository;
import com.stream.streaming_api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    public final UserRepository userRepository;

    @Override
    public User getUser(UUID userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new StreamingException(HttpStatus.NOT_FOUND, new StreamingError(StreamingErrorCode.CODE_404_USERS, StreamingErrorCode.CODE_404_USERS.getMessage()));
        }

        return user.get();
    }
}
