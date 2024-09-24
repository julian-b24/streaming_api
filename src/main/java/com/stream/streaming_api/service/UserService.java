package com.stream.streaming_api.service;

import com.stream.streaming_api.model.User;

import java.util.UUID;

public interface UserService {

    User getUser(UUID userId);

}
