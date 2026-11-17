
package com.klu.service;

import java.util.Date;
import java.util.Map;
import java.util.Base64;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    public String generateToken(Map<String, Object> payload) {

        SecretKey key = Keys.hmacShaKeyFor(
            Base64.getDecoder().decode(secret));

        return Jwts.builder()
            .claims(payload)
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + expiration))
            .signWith(key)
            .compact();
    }
}
