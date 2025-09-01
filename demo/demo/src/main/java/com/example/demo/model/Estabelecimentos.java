package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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

    @Column(nullable = false)
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "categorias_id")
    private Categorias categoria;

    // RELAÇÃO -> Um estabelecimento pode ter vários usuários
    @OneToMany(mappedBy = "estabelecimento", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Usuarios> usuarios = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "estabelecimentos_servicos",
            joinColumns = @JoinColumn(name = "estabelecimentos_id"),
            inverseJoinColumns = @JoinColumn(name = "servicos_id")
    )
    private Set<Servicos> servicos = new HashSet<>();

    @Column(nullable = false)
    private String linkImg;

    public Estabelecimentos() {}

    public Estabelecimentos(Long id, String nome, Locais local, Set<Usuarios> usuarios, LocalDateTime dataCriacao,
                            String senha, Categorias categoria, String linkImg, Set<Servicos> servicos, String telefone) {
        this.id = id;
        this.nome = nome;
        this.local = local;
        this.dataCriacao = dataCriacao;
        this.senha = senha;
        this.categoria = categoria;
        this.linkImg = linkImg;
        this.usuarios = usuarios;
        this.servicos = servicos;
        this.telefone = telefone;
    }

    public Long getId() {return id;}
    public String getNome() {return nome;}
    public String getSenha() {return senha;}
    public LocalDateTime getDataCriacao() {return dataCriacao;}
    public String getLinkImg() {return linkImg;}
    public Categorias getCategoria() {return categoria;}
    public Locais getLocal() {return local;}
    public Set<Usuarios> getUsuarios() {return usuarios;}
    public Set<Servicos> getServicos() {return servicos;}
    public String getTelefone() {return telefone;}

    public void setCategoria(Categorias categoria) {this.categoria = categoria;}
    public void setLocal(Locais local) {this.local = local;}
    public void setNome(String nome) {this.nome = nome;}
    public void setSenha(String senha) {this.senha = senha;}
    public void setDataCriacao(LocalDateTime dataCriacao) {this.dataCriacao = dataCriacao;}
    public void setLinkImg(String linkImg) {this.linkImg = linkImg;}
    public void setUsuarios(Set<Usuarios> usuarios) {this.usuarios = usuarios;}
    public void setServicos(Set<Servicos> servicos) {this.servicos = servicos;}
    public void setTelefone(String telefone) {this.telefone = telefone;}
}
