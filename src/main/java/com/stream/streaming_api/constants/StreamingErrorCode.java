package com.stream.streaming_api.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StreamingErrorCode {
    CODE_404("Content not found in our database."),
    CODE_404_USERS("User not found in our database."),
    CODE_400_LOGIN("Invalid nickname or password."),
    CODE_400_USERS_VIEW("Invalid userId, the user has already marked as seen the content"),
    CODE_400_USERS_RATE("Invalid userId, the user has already rated the content"),
    CODE_401_LOGIN("Not token found or expired token.");

    private String message;
}
