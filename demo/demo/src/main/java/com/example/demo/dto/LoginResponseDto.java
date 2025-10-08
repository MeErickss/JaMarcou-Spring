package com.example.demo.dto;

import java.util.HashSet;
import java.util.Set;

public class LoginResponseDto {
    private String token;
    private Long userId;
    private String roles;

    public LoginResponseDto() {}

    public LoginResponseDto(String token, Long userId, String roles) {
        this.token = token;
        this.userId = userId;
        this.roles = roles;
    }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }


    public String getRoles() {return roles;}
    public void setRoles(String roles) {this.roles = roles;}
}
