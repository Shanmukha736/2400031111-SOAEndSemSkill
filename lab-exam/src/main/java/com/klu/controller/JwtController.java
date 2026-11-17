
package com.klu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.service.JwtService;

@RestController
@RequestMapping("/api/jwt")
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping("/generate")
    public Map<String, String> generateToken(
            @RequestBody Map<String, Object> payload) {

        String token = jwtService.generateToken(payload);

        return Map.of("token", token);
    }
}
