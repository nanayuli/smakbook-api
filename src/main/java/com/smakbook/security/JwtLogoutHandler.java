package com.smakbook.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class JwtLogoutHandler
 * @since 29/11/2024 — 00.01
 **/
@Service
@RequiredArgsConstructor
public class JwtLogoutHandler implements LogoutHandler {
    private final JwtService jwtService;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        String jwt = jwtService.parseJwt(request);
        if (jwt == null) {
            return;
        }
        SecurityContextHolder.clearContext();
    }
}
