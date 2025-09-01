package com.example.demo.model;

import com.example.demo.model.enumeration.Funcoes;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Column(nullable = false)
    private List<Funcoes> funcoes;

    // RELAÇÃO -> Muitos usuários para 1 estabelecimento
    @ManyToOne
    @JoinColumn(name = "estabelecimento_id", nullable = false)
    @JsonIgnore
    private Estabelecimentos estabelecimento;

    @ManyToMany(mappedBy = "usuarios")
    @JsonBackReference(value = "usuario-servico")
    private Set<Servicos> servicos = new HashSet<>();

    // HORARIOS: um usuário possui muitos horários
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "usuario-horario")
    private Set<Horarios> horarios = new HashSet<>();

    public Usuarios() {}

    public Usuarios(Long id, String nome, String email, Estabelecimentos estabelecimento, String sobrenome, String cpf,
                    String senha, List<Funcoes> funcoes, Set<Servicos> servicos, LocalDateTime dataNascimento, String linkImagem, String statusUsuario) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.linkImagem = linkImagem;
        this.statusUsuario = statusUsuario;
        this.email = email;
        this.estabelecimento = estabelecimento;
        this.servicos = servicos;
        this.funcoes = funcoes;
    }

    public Long getId() { return id; }
    public String getCpf() { return cpf; }
    public LocalDateTime getDataNascimento() { return dataNascimento; }
    public String getLinkImagem() { return linkImagem; }
    public String getNome() { return nome; }
    public String getSenha() { return senha; }
    public String getSobrenome() { return sobrenome; }
    public String getStatusUsuario() { return statusUsuario; }
    public Set<Servicos> getServicos() { return servicos; }
    public String getEmail() { return email; }
    public Estabelecimentos getEstabelecimento() { return estabelecimento; }
    public Set<Horarios> getHorarios() { return horarios; }
    public List<Funcoes> getFuncoes() {return funcoes;}

    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setDataNascimento(LocalDateTime dataNascimento) { this.dataNascimento = dataNascimento; }
    public void setLinkImagem(String linkImagem) { this.linkImagem = linkImagem; }
    public void setNome(String nome) { this.nome = nome; }
    public void setSenha(String senha) { this.senha = senha; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }
    public void setStatusUsuario(String statusUsuario) { this.statusUsuario = statusUsuario; }
    public void setServicos(Set<Servicos> servicos) { this.servicos = servicos; }
    public void setEmail(String email) { this.email = email; }
    public void setEstabelecimento(Estabelecimentos estabelecimento) { this.estabelecimento = estabelecimento; }
    public void setHorarios(Set<Horarios> horarios) { this.horarios = horarios; }
    public void setFuncoes(List<Funcoes> funcoes) {this.funcoes = funcoes;}
}
