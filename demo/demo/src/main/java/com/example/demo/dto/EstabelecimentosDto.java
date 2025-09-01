package com.example.demo.dto;

import java.time.LocalDateTime;

public class EstabelecimentosDto {
    private Long id;
    private String nome;
    private Long localId;
    private LocalDateTime dataCriacao;
    private String linkImg;
    private Long categoriaId;
    private String senha;

    public EstabelecimentosDto() {}

    public EstabelecimentosDto(Long id, String nome, Long localId, LocalDateTime dataCriacao, String linkImg, Long categoriaId, String senha) {
        this.id = id;
        this.nome = nome;
        this.localId = localId;
        this.dataCriacao = dataCriacao;
        this.linkImg = linkImg;
        this.categoriaId = categoriaId;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Long getLocalId() {return localId;}
    public LocalDateTime getDataCriacao() {return dataCriacao;}
    public String getLinkImg() {return linkImg;}
    public Long getCategoriaId() {return categoriaId;}
    public String getSenha() {return senha;}
}
