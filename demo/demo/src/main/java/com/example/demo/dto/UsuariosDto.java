package com.example.demo.dto;

import com.example.demo.model.enumeration.Funcoes;

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
    private List<HorariosDto> horarios;
    private List<Funcoes> funcoes;

    public UsuariosDto() {}

    public UsuariosDto(Long id, String email, String nome, List<Funcoes> funcoes, String sobrenome, String cpf, String senha, LocalDateTime dataNascimento, String linkImagem, String statusUsuario, EstabelecimentosDto estabelecimento, List<ServicosDto> servicos, List<HorariosDto> horarios) {
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
        this.horarios = horarios;
        this.funcoes = funcoes;
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
    public List<HorariosDto> getHorarios() { return horarios; }
    public List<Funcoes> getFuncoes() {return funcoes;}
}
