package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.ManyToAny;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "servicos")
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

    @ManyToOne
    @JoinColumn(name = "estabelecimentos_id", nullable = false)
    private Estabelecimentos estabelecimento;

    @ManyToMany
    @JoinTable(
            name = "usuarios_servicos", // tabela intermediária
            joinColumns = @JoinColumn(name = "servico_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    @JsonManagedReference // evita recursão infinita ao serializar
    private List<Usuarios> usuarios = new ArrayList<>();


    public Servicos() {}

    public Servicos(Long id, String nome, Float valor, String descricao, Long quantidadeDisponivel, List<Usuarios> usuarios) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.usuarios = usuarios;
    }

    public Long getId() {return id;}
    public String getNome() {return nome;}
    public String getDescricao() {return descricao;}
    public Float getValor() {return valor;}
    public Estabelecimentos getEstabelecimento() { return estabelecimento; }
    public Long getQuantidadeDisponivel() {return quantidadeDisponivel;}
    public List<Usuarios> getUsuarios() {return usuarios;}

    public void setEstabelecimento(Estabelecimentos estabelecimento) { this.estabelecimento = estabelecimento; }
    public void setNome(String nome) {this.nome = nome;}
    public void setDescricao(String descricao) {this.descricao = descricao;}
    public void setValor(Float valor) {this.valor = valor;}
    public void setQuantidadeDisponivel(Long quantidadeDisponivel) {this.quantidadeDisponivel = quantidadeDisponivel;}
    public void setUsuarios(List<Usuarios> usuarios) {this.usuarios = usuarios;}
}
