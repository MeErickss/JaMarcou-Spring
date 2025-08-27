package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "avaliacoes")
public class Avaliacoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Float nota;

    @OneToOne
    @JoinColumn(name = "horarios_id", referencedColumnName = "id", nullable = false)
    private Horarios horarios;

    @ManyToOne
    @JoinColumn(name = "estabelecimentos_id", nullable = false)
    private Estabelecimentos estabelecimento;


    public Avaliacoes() {}

    public Avaliacoes(Long id, Float nota, Horarios horarios, Estabelecimentos estabelecimento) {
        this.id = id;
        this.nota = nota;
        this.horarios = horarios;
        this.estabelecimento = estabelecimento;
    }

    public Long getId() { return id; }
    public Float getNota() { return nota; }
    public Horarios getHorario() { return horarios; }

    public Estabelecimentos getEstabelecimento() {return estabelecimento;}

    public void setNota(Float nota) { this.nota = nota; }
    public void setHorario(Horarios horarios) { this.horarios = horarios; }
    public void setEstabelecimento(Estabelecimentos estabelecimento) {this.estabelecimento = estabelecimento;}
}
