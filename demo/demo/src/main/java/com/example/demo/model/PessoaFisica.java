package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pessoa_fisica")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_usuario", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("PESSOA")
public class PessoaFisica {
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
    private String telefone;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private LocalDateTime dataNascimento;

    @Column(nullable = false)
    private String linkImagem;

    @Column(nullable = false)
    private String statusUsuario;

    public PessoaFisica() {}

    public PessoaFisica(Long id, String nome, String email, String sobrenome, String cpf,
                        String senha, LocalDateTime dataNascimento, String linkImagem, String statusUsuario, String telefone) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.linkImagem = linkImagem;
        this.statusUsuario = statusUsuario;
        this.email = email;
        this.telefone = telefone;
    }

    // getters
    public Long getId() { return id; }
    public String getCpf() { return cpf; }
    public LocalDateTime getDataNascimento() { return dataNascimento; }
    public String getLinkImagem() { return linkImagem; }
    public String getNome() { return nome; }
    public String getSenha() { return senha; }
    public String getSobrenome() { return sobrenome; }
    public String getStatusUsuario() { return statusUsuario; }
    public String getEmail() { return email; }
    public String getTelefone() {return telefone;}

    // setters
    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setDataNascimento(LocalDateTime dataNascimento) { this.dataNascimento = dataNascimento; }
    public void setLinkImagem(String linkImagem) { this.linkImagem = linkImagem; }
    public void setNome(String nome) { this.nome = nome; }
    public void setSenha(String senha) { this.senha = senha; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }
    public void setStatusUsuario(String statusUsuario) { this.statusUsuario = statusUsuario; }
    public void setEmail(String email) { this.email = email; }
    public void setTelefone(String telefone) {this.telefone = telefone;}
}