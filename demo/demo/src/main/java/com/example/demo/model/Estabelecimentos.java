package com.example.demo.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estabelecimentos")
public class Estabelecimentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToOne
    @JoinColumn(name = "locais_id", referencedColumnName = "id", nullable = false)
    private Locais locais;

    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    @Column(nullable = false)
    private String senha;

    @ManyToOne
    @JoinColumn(name = "categorias_id") // nome da coluna FK
    private Categorias categoria;


    @Column(nullable = false)
    private String linkImg;

    public Estabelecimentos() {}

    public Estabelecimentos(Long id, String nome, Locais locais, List<Usuarios> usuarios, LocalDateTime dataCriacao, String senha, Categorias categoria, String linkImg) {
        this.id = id;
        this.nome = nome;
        this.locais = locais;
        this.dataCriacao = dataCriacao;
        this.senha = senha;
        this.categoria = categoria;
        this.linkImg = linkImg;
    }

    public Long getId() {return id;}
    public String getNome() {return nome;}
    public String getSenha() {return senha;}
    public LocalDateTime getDataCriacao() {return dataCriacao;}
    public String getLinkImg() {return linkImg;}
    public Categorias getCategoria() {return categoria;}
    public Locais getLocal() {return locais;}


    public void setCategoria(Categorias categoria) {this.categoria = categoria;}
    public void setLocal(Locais locais) {this.locais = locais;}
    public void setNome(String nome) {this.nome = nome;}
    public void setSenha(String senha) {this.senha = senha;}
    public void setDataCriacao(LocalDateTime dataCriacao) {this.dataCriacao = dataCriacao;}
    public void setLinkImg(String linkImg) {this.linkImg = linkImg;}
}
