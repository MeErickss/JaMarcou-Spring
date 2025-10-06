package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "locacoes")
public class Locacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ex: "Quadra 1", "Sala A"
    @Column(nullable = false)
    private String nome;

    @Column(nullable = true)
    private String descricao;

    @Column(nullable = true)
    private Float valorHora;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "estabelecimento_id", nullable = false)
    @JsonBackReference(value = "estabelecimento-locacoes")
    private Estabelecimentos estabelecimento;

    @OneToMany(mappedBy = "locacao", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "locacao-horario")
    private Set<HorariosLocacao> horarios = new HashSet<>();

    public Locacoes() {}

    public Locacoes(Long id, String nome, String descricao, Float valorHora, Estabelecimentos estabelecimento, Set<HorariosLocacao> horarios) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valorHora = valorHora;
        this.estabelecimento = estabelecimento;
        this.horarios = horarios;
    }

    // getters / setters
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public Float getValorHora() { return valorHora; }
    public Estabelecimentos getEstabelecimento() { return estabelecimento; }
    public Set<HorariosLocacao> getHorarios() {return horarios;}

    public void setNome(String nome) { this.nome = nome; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setValorHora(Float valorHora) { this.valorHora = valorHora; }
    public void setEstabelecimento(Estabelecimentos estabelecimento) { this.estabelecimento = estabelecimento; }
    public void setHorarios(Set<HorariosLocacao> horarios) {this.horarios = horarios;}
}
