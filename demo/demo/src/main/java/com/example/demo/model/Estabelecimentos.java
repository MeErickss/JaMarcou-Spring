package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.OffsetDateTime;
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

    @Column(nullable = false)
    private String cnpj;

    @ManyToOne
    @JoinColumn(name = "locais_id", referencedColumnName = "id", nullable = false)
    private Locais local;

    @Column(nullable = false)
    private OffsetDateTime dataCriacao;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = true)
    private String linkImg;

    @Column(nullable = true, length = 1000)
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categoria_id", referencedColumnName = "id", nullable = false)
    private Categorias categoria;

    // gerentes / funcionarios (mantidos)
    @OneToMany(mappedBy = "estabelecimento", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "estabelecimento-gerentes")
    private Set<Gerentes> gerentes = new HashSet<>();

    @OneToMany(mappedBy = "estabelecimento", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "estabelecimento-funcionarios")
    private Set<Funcionarios> funcionarios = new HashSet<>();

    // NOVO: serviços vinculados ao estabelecimento
    @OneToMany(mappedBy = "estabelecimento", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "estabelecimento-servicos")
    private Set<Servicos> servicos = new HashSet<>();

    // NOVO: locações vinculadas ao estabelecimento
    @OneToMany(mappedBy = "estabelecimento", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "estabelecimento-locacoes")
    private Set<Locacoes> locacoes = new HashSet<>();

    public Estabelecimentos() {}

    public Estabelecimentos(Long id, String nome, Locais local, OffsetDateTime dataCriacao, Categorias categoria,
                            String senha, String telefone, String linkImg, String descricao, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.local = local;
        this.dataCriacao = dataCriacao;
        this.senha = senha;
        this.telefone = telefone;
        this.linkImg = linkImg;
        this.descricao = descricao;
        this.cnpj = cnpj;
        this.categoria = categoria;
    }

    // getters / setters (inclui servicos e locacoes)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Locais getLocal() { return local; }
    public void setLocal(Locais local) { this.local = local; }

    public OffsetDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(OffsetDateTime dataCriacao) { this.dataCriacao = dataCriacao; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getLinkImg() { return linkImg; }
    public void setLinkImg(String linkImg) { this.linkImg = linkImg; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Set<Gerentes> getGerentes() { return gerentes; }
    public void setGerentes(Set<Gerentes> gerentes) { this.gerentes = gerentes; }

    public Set<Funcionarios> getFuncionarios() { return funcionarios; }
    public void setFuncionarios(Set<Funcionarios> funcionarios) { this.funcionarios = funcionarios; }

    public Set<Servicos> getServicos() { return servicos; }
    public void setServicos(Set<Servicos> servicos) { this.servicos = servicos; }

    public Set<Locacoes> getLocacoes() { return locacoes; }
    public void setLocacoes(Set<Locacoes> locacoes) { this.locacoes = locacoes; }

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public Categorias getCategoria() {return categoria;}
    public void setCategoria(Categorias categoria) {this.categoria = categoria;}
}
