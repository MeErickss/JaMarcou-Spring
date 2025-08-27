package com.example.demo.dto;

public class LoginDto {
    private String senha;
    private String email;

    public LoginDto(){}

    public LoginDto(String senha, String email){
        this.senha = senha;
        this.email = email;
    }

    public String getEmail() {return email;}
    public String getSenha() {return senha;}

    public void setSenha(String senha) {this.senha = senha;}
    public void setEmail(String email) {this.email = email;}
}
