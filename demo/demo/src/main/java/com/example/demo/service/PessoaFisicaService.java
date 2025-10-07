package com.example.demo.service;

import com.example.demo.model.PessoaFisica;
import com.example.demo.repository.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Service
public class PessoaFisicaService {

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    private final PasswordEncoder encoder = new BCryptPasswordEncoder();

    public PessoaFisica createPessoaFisica(String email,
                                           String nome,
                                           String sobrenome,
                                           String cpf,
                                           String senha,
                                           LocalDateTime dataNascimento,
                                           String linkImg,
                                           String statusUsuario) {
        PessoaFisica p = new PessoaFisica();
        p.setEmail(email);
        p.setNome(nome);
        p.setSobrenome(sobrenome);
        p.setCpf(cpf);

        if (senha == null) {
            throw new IllegalArgumentException("Senha não pode ser nula");
        }
        String hashed = encoder.encode(senha);
        p.setSenha(hashed);

        p.setDataNascimento(dataNascimento);
        p.setLinkImagem(linkImg);
        p.setStatusUsuario(statusUsuario);
        return pessoaFisicaRepository.save(p);
    }

    public String logar(String email, String senha) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email obrigatório");
        }
        if (senha == null) {
            throw new IllegalArgumentException("Senha obrigatória");
        }

        PessoaFisica p = pessoaFisicaRepository.findByEmail(email);
        if (p == null) {
            throw new IllegalArgumentException("Usuário não encontrado para o email informado");
        }

        if (!encoder.matches(senha, p.getSenha())) {
            throw new IllegalArgumentException("Senha inválida");
        }

        return JwtService.gerarToken(p.getEmail());
    }

    public PessoaFisica validarToken(String token) {
        if (token == null || token.isBlank()) return null;

        String email = JwtService.validarToken(token);
        if (email == null) return null;

        return pessoaFisicaRepository.findByEmail(email);
    }
}
