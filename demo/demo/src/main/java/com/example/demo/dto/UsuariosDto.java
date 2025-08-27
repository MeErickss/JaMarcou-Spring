package com.example.demo.dto;

import java.time.LocalDateTime;
import java.util.List;

public class UsuariosDto {
    private Long id;
    private String email;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String senha;
    private LocalDateTime dataNascimento;
    private String linkImagem;
    private String statusUsuario;
    private EstabelecimentosDto estabelecimento;
    private List<ServicosDto> servicos;

    public UsuariosDto() {}

    public UsuariosDto(Long id, String email, String nome, String sobrenome, String cpf, String senha, LocalDateTime dataNascimento, String linkImagem, String statusUsuario, EstabelecimentosDto estabelecimento, List<ServicosDto> servicos) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.linkImagem = linkImagem;
        this.statusUsuario = statusUsuario;
        this.estabelecimento = estabelecimento;
        this.servicos = servicos;
    }

    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getNome() { return nome; }
    public String getSobrenome() { return sobrenome; }
    public String getCpf() { return cpf; }
    public String getSenha() { return senha; }
    public LocalDateTime getDataNascimento() { return dataNascimento; }
    public String getLinkImagem() { return linkImagem; }
    public String getStatusUsuario() { return statusUsuario; }
    public EstabelecimentosDto getEstabelecimento() { return estabelecimento; }
    public List<ServicosDto> getServicos() { return servicos; }
}
