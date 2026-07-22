package com.cognizant.springlearn.controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
    private static final String SECRET_KEY = "secretkeysecretkeysecretkeysecretkey"; // 36 bytes

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("START authenticate request");
        LOGGER.debug("Authorization Header Received: {}", authHeader);

        String username = getUser(authHeader);
        String jwtToken = generateJwt(username);

        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("token", jwtToken);
        LOGGER.info("END authenticate request");
        return resultMap;
    }

    private String getUser(String authHeader) {
        LOGGER.info("START getUser decoding");
        String encodedAuth = authHeader.replace("Basic ", "").trim();
        byte[] decodedBytes = Base64.getDecoder().decode(encodedAuth);
        String credentialsString = new String(decodedBytes, StandardCharsets.UTF_8);
        String user = credentialsString.split(":")[0];
        LOGGER.debug("Extracted user from Basic Auth: {}", user);
        LOGGER.info("END getUser decoding");
        return user;
    }

    private String generateJwt(String user) {
        LOGGER.info("START generateJwt token creation");
        Key signingKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setSubject(user);
        jwtBuilder.setIssuedAt(new Date());
        // Set token expiration to 20 minutes (1200000 ms)
        jwtBuilder.setExpiration(new Date(System.currentTimeMillis() + 1200000));
        jwtBuilder.signWith(signingKey, SignatureAlgorithm.HS256);

        String generatedToken = jwtBuilder.compact();
        LOGGER.debug("Generated JWT Token: {}", generatedToken);
        LOGGER.info("END generateJwt token creation");
        return generatedToken;
    }
}
