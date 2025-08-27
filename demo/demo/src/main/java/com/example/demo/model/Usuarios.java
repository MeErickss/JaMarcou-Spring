package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private LocalDateTime dataNascimento;

    @Column(nullable = false)
    private String linkImagem;

    @Column(nullable = false)
    private String statusUsuario;

    @ManyToOne
    @JoinColumn(name = "estabelecimentos_id", nullable = false)
    private Estabelecimentos estabelecimento;

    @ManyToMany(mappedBy = "usuarios")
    @JsonBackReference
    private List<Servicos> servicos = new ArrayList<>();


    public Usuarios() {}

    public Usuarios(Long id, String nome, String email, String sobrenome, String cpf, String senha, List<Servicos> servicos ,LocalDateTime dataNascimento, String linkImagem, String statusUsuario, Estabelecimentos estabelecimento) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.linkImagem = linkImagem;
        this.statusUsuario = statusUsuario;
        this.estabelecimento = estabelecimento;
        this.servicos = servicos;
        this.email = email;
    }

    public Long getId() {return id;}
    public String getCpf() {return cpf;}
    public LocalDateTime getDataNascimento() {return dataNascimento;}
    public String getLinkImagem() {return linkImagem;}
    public String getNome() {return nome;}
    public String getSenha() {return senha;}
    public String getSobrenome() {return sobrenome;}
    public String getStatusUsuario() {return statusUsuario;}
    public Estabelecimentos getEstabelecimento() { return estabelecimento; }
    public List<Servicos> getServicos() {return servicos;}
    public String getEmail() {return email;}

    public void setCpf(String cpf) {this.cpf = cpf;}
    public void setDataNascimento(LocalDateTime dataNascimento) {this.dataNascimento = dataNascimento;}
    public void setLinkImagem(String linkImagem) {this.linkImagem = linkImagem;}
    public void setNome(String nome) {this.nome = nome;}
    public void setSenha(String senha) {this.senha = senha;}
    public void setSobrenome(String sobrenome) {this.sobrenome = sobrenome;}
    public void setStatusUsuario(String statusUsuario) {this.statusUsuario = statusUsuario;}
    public void setEstabelecimento(Estabelecimentos estabelecimento) { this.estabelecimento = estabelecimento; }
    public void setServicos(List<Servicos> servicos) {this.servicos = servicos;}
    public void setEmail(String email) {this.email = email;}
}
