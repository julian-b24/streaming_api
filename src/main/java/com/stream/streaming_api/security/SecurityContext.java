package com.stream.streaming_api.security;

import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.Serializable;
import java.util.Optional;
import java.util.UUID;


@Setter
//@EqualsAndHashCode
//@ToString
public class SecurityContext implements Serializable {

    private static final long serialVersionUID = 4659821160803661194L;

    private String userNickname;

    private String token;

    public String getUserNickname() {
        return Optional.ofNullable(userNickname).orElseThrow();
    }


    public String getToken() {
        return token;
    }

}
