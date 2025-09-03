package com.example.demo.dto;

public class LoginGoogleDto {
    private String email;
    private String token;

    public LoginGoogleDto(){}

    public LoginGoogleDto(String token, String email){
        this.email = email;
        this.token = token;
    }

    public String getEmail() {return email;}
    public String getToken() {return token;}
}
