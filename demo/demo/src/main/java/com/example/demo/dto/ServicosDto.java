package com.example.demo.dto;

import java.util.List;
import java.util.Set;

public class ServicosDto {
    private Long id;
    private String nome;
    private Float valor;
    private String descricao;
    private Long quantidadeDisponivel;

    public ServicosDto() {}

    public ServicosDto(Long id, String nome, Float valor, String descricao, Long quantidadeDisponivel) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public Float getValor() { return valor; }
    public String getDescricao() { return descricao; }
    public Long getQuantidadeDisponivel() { return quantidadeDisponivel; }
}
