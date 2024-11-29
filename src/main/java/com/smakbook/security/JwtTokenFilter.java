package com.smakbook.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.io.IOException;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class JwtTokenFilter
 * @since 28/11/2024 — 23.24
 **/
@Component
@Slf4j
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        try  {
            String jwt = jwtService.parseJwt(request);

            // Check if JWT is valid and if token is valid
            if (jwt != null && jwtService.isTokenValid(jwt)) {
                String email = jwtService.getUsernameFromToken(jwt);
                UserDetailsImpl userDetails = (UserDetailsImpl) userDetailsService.loadUserByUsername(email);

                // Create an authentication token with the user details
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                // Set additional details for the authentication token
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // Set the authentication token in the security context
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        } catch (Exception e) {
            log.error("Couldn't set user authentication: {}", e.getMessage());
        }

        // Continue the filter chain
        filterChain.doFilter(request, response);
    }
}
