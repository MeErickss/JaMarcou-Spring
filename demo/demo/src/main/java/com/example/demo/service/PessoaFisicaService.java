package com.example.demo.service;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.LoginResponseDto;
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

    public LoginResponseDto logar(LoginDto dto) {
        if (dto.getEmail() == null || dto.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email obrigatório");
        }
        if (dto.getSenha() == null) {
            throw new IllegalArgumentException("Senha obrigatória");
        }

        PessoaFisica p = pessoaFisicaRepository.findByEmail(dto.getEmail());
        if (p == null) {
            throw new IllegalArgumentException("Usuário não encontrado para o email informado");
        }

        if (!encoder.matches(dto.getSenha(), p.getSenha())) {
            throw new IllegalArgumentException(dto.getSenha() + "Senha inválida" + p.getSenha());
        }

        // Detecta role (maneira simples)
        String role = detectRole(p);

        // Gera token com claim de role (ex.: JwtService.gerarToken(email, role))
        String token = JwtService.gerarToken(p.getEmail());

        return new LoginResponseDto(token, p.getId(), role);
    }

    private String detectRole(PessoaFisica p) {
        // 1) verificação por instanceof (normalmente funciona quando JPA devolve a subclasse)
        if (p instanceof com.example.demo.model.Clientes) return "CLIENTE";
        if (p instanceof com.example.demo.model.Funcionarios) return "FUNCIONARIO";
        if (p instanceof com.example.demo.model.Gerentes) return "GERENTE";
        return "PESSOA";
    }

    public PessoaFisica validarToken(String token) {
        if (token == null || token.isBlank()) return null;

        String email = JwtService.validarToken(token);
        if (email == null) return null;

        return pessoaFisicaRepository.findByEmail(email);
    }
}
