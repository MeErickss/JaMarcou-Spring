package com.example.demo.dto;

public class CategoriasDto {
    private Long id;
    private String nome;
    private String descricao;

    public CategoriasDto() {}

    public CategoriasDto(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Long getId() {return id;}
    public String getNome() {return nome;}
    public String getDescricao() {return descricao;}
}
