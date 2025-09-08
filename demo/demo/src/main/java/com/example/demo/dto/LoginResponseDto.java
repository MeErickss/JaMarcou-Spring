package com.example.demo.dto;

import com.example.demo.model.enumeration.Funcoes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LoginResponseDto {
    private String token;
    private Long userId;
    private Set<Funcoes> funcoes = new HashSet<>();

    public LoginResponseDto() {}

    public LoginResponseDto(String token, Long userId, Set<Funcoes> funcoes) {
        this.token = token;
        this.userId = userId;
        this.funcoes = funcoes;
    }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
    public Set<Funcoes> getFuncoes() {return funcoes;}

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setFuncoes(Set<Funcoes> funcoes) {this.funcoes = funcoes;}
}
