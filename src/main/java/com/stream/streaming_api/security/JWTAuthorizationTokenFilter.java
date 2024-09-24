package com.stream.streaming_api.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stream.streaming_api.constants.StreamingErrorCode;
import com.stream.streaming_api.error.exception.StreamingError;
import com.stream.streaming_api.error.exception.StreamingException;
import com.stream.streaming_api.utils.JWTParser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

//@Component
//@Order(1)
public class JWTAuthorizationTokenFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JWTAuthorizationTokenFilter.class);

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String TOKEN_PREFIX = "Bearer ";

    private static final String USER_NICKNAME_CLAIM_NAME = "nickname";

    private static final String[] excludedPaths = {"/api/v1/auth/login", "/api/v1/auth/refresh-token"};


    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain)
            throws ServletException, IOException {
        logger.info("Request: Method={}, URI={}",
                request.getMethod(),
                request.getRequestURI());
        return;
/*        try {

            if (containsToken(request)) {
                String jwtToken = request.getHeader(AUTHORIZATION_HEADER).replace(TOKEN_PREFIX, "");
                Claims claims = JWTParser.decodeJWT(jwtToken);
                SecurityContext context = parseClaims(jwtToken, claims);
                SecurityContextHolder.setUserContext(context);
                filterChain.doFilter(request, response);
            } else {
                createUnauthorizedFilter(new StreamingException(HttpStatus.UNAUTHORIZED, new StreamingError(StreamingErrorCode.CODE_401_LOGIN, StreamingErrorCode.CODE_401_LOGIN.getMessage())), response);
            }
        } finally {
            SecurityContextHolder.clearContext();
        }*/
    }


    @SneakyThrows
    private void createUnauthorizedFilter(StreamingException streamingException, HttpServletResponse response) {
        ObjectMapper objectMapper = new ObjectMapper();
        StreamingError streamingError = streamingException.getError();
        String message = objectMapper.writeValueAsString(streamingError);

        response.setStatus(401);
        response.setHeader(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON_VALUE);
        response.getWriter().write(message);
        response.getWriter().flush();
    }

    private SecurityContext parseClaims(String jwtToken, Claims claims) {
        String userNickname = claimKey(claims, USER_NICKNAME_CLAIM_NAME);

        SecurityContext context = new SecurityContext();
        try {
            context.setUserNickname(userNickname);
            context.setToken(jwtToken);
        } catch (IllegalArgumentException e) {
            throw new MalformedJwtException("Error parsing jwt");
        }
        return context;
    }

    private String claimKey(Claims claims, String key) {
        String value = (String) claims.get(key);
        return Optional.ofNullable(value).orElseThrow();
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
            return true;
        }

        String requestPath = request.getRequestURI();
        return Arrays.stream(excludedPaths).anyMatch(path -> path.equalsIgnoreCase(requestPath));
    }

    private boolean containsToken(HttpServletRequest request) {
        String authenticationHeader = request.getHeader(AUTHORIZATION_HEADER);
        return authenticationHeader != null && authenticationHeader.startsWith(TOKEN_PREFIX);
    }
}
