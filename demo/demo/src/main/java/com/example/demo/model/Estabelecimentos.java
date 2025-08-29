package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private Locais local;

    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    @Column(nullable = false)
    private String senha;

    @ManyToOne
    @JoinColumn(name = "categorias_id") // nome da coluna FK
    private Categorias categoria;

    @ManyToMany
    @JoinTable(
            name = "estabelecimentos_usuarios", // nome da tabela de junção
            joinColumns = @JoinColumn(name = "estabelecimento_id"), // FK para esta entidade
            inverseJoinColumns = @JoinColumn(name = "usuario_id")    // FK para a outra entidade
    )
    @JsonIgnore
    private List<Usuarios> usuarios = new ArrayList<>();


    @Column(nullable = false)
    private String linkImg;

    public Estabelecimentos() {}

    public Estabelecimentos(Long id, String nome, Locais local, List<Usuarios> usuarios, LocalDateTime dataCriacao, String senha, Categorias categoria, String linkImg) {
        this.id = id;
        this.nome = nome;
        this.local = local;
        this.dataCriacao = dataCriacao;
        this.senha = senha;
        this.categoria = categoria;
        this.linkImg = linkImg;
        this.usuarios = usuarios;
    }

    public Long getId() {return id;}
    public String getNome() {return nome;}
    public String getSenha() {return senha;}
    public LocalDateTime getDataCriacao() {return dataCriacao;}
    public String getLinkImg() {return linkImg;}
    public Categorias getCategoria() {return categoria;}
    public Locais getLocal() {return local;}
    public List<Usuarios> getUsuarios() {return usuarios;}

    public void setCategoria(Categorias categoria) {this.categoria = categoria;}
    public void setLocal(Locais local) {this.local = local;}
    public void setNome(String nome) {this.nome = nome;}
    public void setSenha(String senha) {this.senha = senha;}
    public void setDataCriacao(LocalDateTime dataCriacao) {this.dataCriacao = dataCriacao;}
    public void setLinkImg(String linkImg) {this.linkImg = linkImg;}
    public void setUsuarios(List<Usuarios> usuarios) {this.usuarios = usuarios;}
}
