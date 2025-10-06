package com.example.demo.dto;

import java.util.HashSet;
import java.util.Set;

public class LoginResponseDto {
    private String token;
    private Long userId;

    public LoginResponseDto() {}

    public LoginResponseDto(String token, Long userId) {
        this.token = token;
        this.userId = userId;
    }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}
