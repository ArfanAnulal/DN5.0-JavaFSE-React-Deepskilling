package com.cognizant.springlearn.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.ArrayList;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthorizationFilter.class);
    private static final String SECRET_KEY = "secretkeysecretkeysecretkeysecretkey"; // 36 bytes

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
        LOGGER.info("Initializing JwtAuthorizationFilter");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res,
            FilterChain chain) throws IOException, ServletException {
        LOGGER.info("START doFilterInternal processing");
        String header = req.getHeader("Authorization");
        LOGGER.debug("Incoming Authorization Header: {}", header);

        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(req, res);
            return;
        }

        UsernamePasswordAuthenticationToken authToken = getAuthentication(req);
        if (authToken != null) {
            SecurityContextHolder.getContext().setAuthentication(authToken);
        }
        chain.doFilter(req, res);
        LOGGER.info("END doFilterInternal processing");
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String tokenHeader = request.getHeader("Authorization");
        if (tokenHeader != null) {
            try {
                Key signingKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
                Jws<Claims> claimsJws = Jwts.parserBuilder()
                        .setSigningKey(signingKey)
                        .build()
                        .parseClaimsJws(tokenHeader.replace("Bearer ", "").trim());
                
                String username = claimsJws.getBody().getSubject();
                LOGGER.debug("Successfully validated JWT for user: {}", username);
                if (username != null) {
                    return new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
                }
            } catch (JwtException ex) {
                LOGGER.error("JWT verification failed: {}", ex.getMessage());
                return null;
            }
        }
        return null;
    }
}
