package com.security.jwt.jwtsecurity.Configuration;

import java.io.IOException;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(
        @NonNull HttpServletRequest request, 
        @NonNull HttpServletResponse response, 
        @NonNull FilterChain filterChain)
            throws ServletException, IOException {
        
                final String authHeader = request.getHeader("Authorization");
                final String jwt;
                final String userEmail;

                if(authHeader == null || !authHeader.startsWith("Bearer ")){

                    //It will forward the request to next filter 
                    filterChain.doFilter(request, response);
                    return;
                }
                
                jwt = authHeader.substring(7);
                userEmail = jwtService.extractUsername(jwt);

    }
    
}
