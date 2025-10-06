package com.example.demo.model;

import com.example.demo.model.enumeration.DiasSemana;
import com.example.demo.model.enumeration.StatusHorario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "horarios_locacao")
public class HorariosLocacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private DiasSemana diaSemana;

    @Column(nullable = false)
    private Timestamp dataInicio;

    @Column(nullable = false)
    private Timestamp dataFim;

    // qual locacao (ex: quadra1) tem este horário disponível
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "locacao_id", nullable = false)
    @JsonBackReference(value = "locacao-horario")
    private Locacoes locacao;

    // quando foi criada/registrada essa disponibilidade (opcional)
    @Column(nullable = true)
    private LocalDateTime dataCriacao;

    @Column(nullable = false)
    private StatusHorario statusHorario;

    public HorariosLocacao() {}

    public HorariosLocacao(Long id, DiasSemana diaSemana, Timestamp dataInicio, Timestamp dataFim,
                           Locacoes locacao, LocalDateTime dataCriacao, StatusHorario statusHorario) {
        this.id = id;
        this.diaSemana = diaSemana;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.locacao = locacao;
        this.dataCriacao = dataCriacao;
        this.statusHorario = statusHorario;
    }

    // getters / setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public DiasSemana getDiaSemana() { return diaSemana; }
    public void setDiaSemana(DiasSemana diaSemana) { this.diaSemana = diaSemana; }

    public Timestamp getDataInicio() { return dataInicio; }
    public void setDataInicio(Timestamp dataInicio) { this.dataInicio = dataInicio; }

    public Timestamp getDataFim() { return dataFim; }
    public void setDataFim(Timestamp dataFim) { this.dataFim = dataFim; }

    public Locacoes getLocacao() { return locacao; }
    public void setLocacao(Locacoes locacao) { this.locacao = locacao; }

    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }

    public StatusHorario getStatusHorario() { return statusHorario; }
    public void setStatusHorario(StatusHorario statusHorario) { this.statusHorario = statusHorario; }
}