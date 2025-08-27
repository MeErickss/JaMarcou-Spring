package com.example.demo.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtService {

    // Chave secreta (em produção use variável de ambiente)
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String gerarToken(String email) {
        return Jwts.builder()
                .setSubject(email) // ou ID do usuário
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1h de validade
                .signWith(SECRET_KEY)
                .compact();
    }

    public static String validarToken(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject(); // Retorna o email ou id do usuário
        } catch (Exception e) {
            return null; // token inválido ou expirado
        }
    }
}
