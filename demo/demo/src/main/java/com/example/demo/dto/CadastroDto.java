package com.example.demo.dto;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

public class CadastroDto {
    private String nome;
    private EnderecoDto endereco;
    private List<HorariosCadastroDto> horarios;
    private OffsetDateTime dataCriacao;
    private String linkImg;
    private Long categoriaId;
    private String senha;
    private String telefone;
    private String descricao;
    private List<ServicosDto> servicos;
    private String usuarioLogin;

    public CadastroDto() {}

    public CadastroDto(String nome, EnderecoDto endereco, List<HorariosCadastroDto> horarios, String usuarioLogin, List<ServicosDto> servicos, OffsetDateTime dataCriacao, String linkImg, Long categoriaId, String senha, String telefone, String descricao) {
        this.nome = nome;
        this.endereco = endereco;
        this.dataCriacao = dataCriacao;
        this.linkImg = linkImg;
        this.categoriaId = categoriaId;
        this.senha = senha;
        this.telefone = telefone;
        this.descricao = descricao;
        this.servicos = servicos;
        this.horarios = horarios;
        this.usuarioLogin = usuarioLogin;
    }

    public String getNome() {return nome;}
    public String getLinkImg() {return linkImg;}
    public Long getCategoriaId() {return categoriaId;}
    public String getSenha() {return senha;}
    public String getTelefone() {return telefone;}
    public String getDescricao() {return descricao;}
    public EnderecoDto getEndereco() {return endereco;}
    public List<HorariosCadastroDto> getHorarios() {return horarios;}
    public List<ServicosDto> getServicos() {return servicos;}
    public OffsetDateTime getDataCriacao() {return dataCriacao;}
    public String getUsuarioLogin() {return usuarioLogin;}
}
