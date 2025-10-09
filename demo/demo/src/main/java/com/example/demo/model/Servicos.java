package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "servicos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Servicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Float valor;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Long quantidadeDisponivel;

    // cada serviço pertence a UM estabelecimento
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "estabelecimento_id", nullable = false)
    @JsonBackReference(value = "estabelecimento-servicos")
    private Estabelecimentos estabelecimento;

    // cada serviço é prestado por UM funcionário (OBRIGATÓRIO no seu domínio)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "prestador_id", nullable = false)
    @JsonBackReference(value = "funcionario-servicos")
    private Funcionarios prestador;

    public Servicos() {}

    public Servicos(Long id, String nome, Float valor, String descricao, Long quantidadeDisponivel,
                    Estabelecimentos estabelecimento, Funcionarios prestador) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.estabelecimento = estabelecimento;
        this.prestador = prestador;
    }

    // getters / setters
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public Float getValor() { return valor; }
    public Long getQuantidadeDisponivel() { return quantidadeDisponivel; }
    public Estabelecimentos getEstabelecimento() { return estabelecimento; }
    public Funcionarios getPrestador() { return prestador; }

    public void setNome(String nome) { this.nome = nome; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setValor(Float valor) { this.valor = valor; }
    public void setQuantidadeDisponivel(Long quantidadeDisponivel) { this.quantidadeDisponivel = quantidadeDisponivel; }
    public void setEstabelecimento(Estabelecimentos estabelecimento) { this.estabelecimento = estabelecimento; }
    public void setPrestador(Funcionarios prestador) { this.prestador = prestador; }
}
