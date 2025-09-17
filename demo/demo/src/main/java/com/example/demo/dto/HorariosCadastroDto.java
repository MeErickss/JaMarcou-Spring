package com.example.demo.dto;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

public class HorariosCadastroDto {
    private String nome;
    private EnderecoDto endereco;
    private List<HorariosDto> horarios;
    private OffsetDateTime dataCriacao;
    private String linkImg;
    private Long categoriaId;
    private String senha;
    private String telefone;
    private String descricao;
    private List<ServicosDto> servicos;

    public HorariosCadastroDto() {}

    public HorariosCadastroDto(String nome, EnderecoDto endereco, List<HorariosDto> horarios, List<ServicosDto> servicos, OffsetDateTime dataCriacao, String linkImg, Long categoriaId, String senha, String telefone, String descricao) {
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
    }

    public String getNome() {return nome;}
    public String getLinkImg() {return linkImg;}
    public Long getCategoriaId() {return categoriaId;}
    public String getSenha() {return senha;}
    public String getTelefone() {return telefone;}
    public String getDescricao() {return descricao;}
    public EnderecoDto getEndereco() {return endereco;}
    public List<HorariosDto> getHorarios() {return horarios;}
    public List<ServicosDto> getServicos() {return servicos;}
    public OffsetDateTime getDataCriacao() {return dataCriacao;}
}
