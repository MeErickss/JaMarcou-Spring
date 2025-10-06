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
    private HorariosFuncionario horariosFuncionario;

    @ManyToOne
    @JoinColumn(name = "estabelecimentos_id", nullable = false)
    private Estabelecimentos estabelecimento;


    public Avaliacoes() {}

    public Avaliacoes(Long id, Float nota, HorariosFuncionario horariosFuncionario, Estabelecimentos estabelecimento) {
        this.id = id;
        this.nota = nota;
        this.horariosFuncionario = horariosFuncionario;
        this.estabelecimento = estabelecimento;
    }

    public Long getId() { return id; }
    public Float getNota() { return nota; }
    public HorariosFuncionario getHorario() { return horariosFuncionario; }

    public Estabelecimentos getEstabelecimento() {return estabelecimento;}

    public void setNota(Float nota) { this.nota = nota; }
    public void setHorario(HorariosFuncionario horariosFuncionario) { this.horariosFuncionario = horariosFuncionario; }
    public void setEstabelecimento(Estabelecimentos estabelecimento) {this.estabelecimento = estabelecimento;}
}
