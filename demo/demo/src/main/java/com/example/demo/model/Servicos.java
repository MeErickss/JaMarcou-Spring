package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(
            name = "usuarios_servicos", // tabela intermediária
            joinColumns = @JoinColumn(name = "servico_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    @JsonManagedReference // evita recursão infinita ao serializar
    private Set<Usuarios> usuarios = new HashSet<>();

    @ManyToMany(mappedBy = "servicos")
    @JsonIgnore
    private Set<Estabelecimentos> estabelecimentos = new HashSet<>();

    // NOVO: agendamentos que usam este servico
    @OneToMany(mappedBy = "servico", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference(value = "servico-agendamentos")
    private Set<Agendamentos> agendamentos = new HashSet<>();

    public Servicos() {}

    public Servicos(Long id, String nome, Float valor, String descricao, Long quantidadeDisponivel, Set<Usuarios> usuarios, Set<Estabelecimentos> estabelecimentos) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.usuarios = usuarios;
        this.estabelecimentos = estabelecimentos;
    }

    public Long getId() {return id;}
    public String getNome() {return nome;}
    public String getDescricao() {return descricao;}
    public Float getValor() {return valor;}
    public Long getQuantidadeDisponivel() {return quantidadeDisponivel;}
    public Set<Usuarios> getUsuarios() {return usuarios;}
    public Set<Estabelecimentos> getEstabelecimentos() {return estabelecimentos;}
    public Set<Agendamentos> getAgendamentos() { return agendamentos; }

    public void setNome(String nome) {this.nome = nome;}
    public void setDescricao(String descricao) {this.descricao = descricao;}
    public void setValor(Float valor) {this.valor = valor;}
    public void setQuantidadeDisponivel(Long quantidadeDisponivel) {this.quantidadeDisponivel = quantidadeDisponivel;}
    public void setUsuarios(Set<Usuarios> usuarios) {this.usuarios = usuarios;}
    public void setEstabelecimentos(Set<Estabelecimentos> estabelecimentos) {this.estabelecimentos = estabelecimentos;}
    public void setAgendamentos(Set<Agendamentos> agendamentos) { this.agendamentos = agendamentos; }
}
