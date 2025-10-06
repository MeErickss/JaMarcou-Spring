package com.example.demo.model;

import com.example.demo.model.enumeration.DiasSemana;
import com.example.demo.model.enumeration.StatusHorario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.example.demo.model.enumeration.DiasSemana;
import com.example.demo.model.enumeration.StatusHorario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "horarios_funcionario")
public class HorariosFuncionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private DiasSemana diaSemana;

    @Column(nullable = false)
    private Timestamp dataInicio;

    @Column(nullable = false)
    private Timestamp dataFim;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "funcionarios_id", nullable = true)
    @JsonBackReference(value = "funcionario-horario")
    private Funcionarios funcionario;

    @Column(nullable = false)
    private StatusHorario statusHorario;

    public HorariosFuncionario() {}

    public HorariosFuncionario(Long id, Timestamp dataInicio, Timestamp dataFim, DiasSemana diaSemana,
                               Funcionarios funcionario, StatusHorario statusHorario) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.funcionario = funcionario;
        this.diaSemana = diaSemana;
        this.statusHorario = statusHorario;
    }

    // getters / setters
    public Long getId() { return id; }
    public Timestamp getDataFim() { return dataFim; }
    public Timestamp getDataInicio() { return dataInicio; }
    public StatusHorario getStatusHorario() { return statusHorario; }
    public Funcionarios getFuncionario() { return funcionario; }
    public DiasSemana getDiaSemana() { return diaSemana; }

    public void setDataFim(Timestamp dataFim) { this.dataFim = dataFim; }
    public void setDataInicio(Timestamp dataInicio) { this.dataInicio = dataInicio; }
    public void setStatusHorario(StatusHorario statusHorario) { this.statusHorario = statusHorario; }
    public void setFuncionario(Funcionarios funcionario) { this.funcionario = funcionario; }
    public void setDiaSemana(DiasSemana diaSemana) { this.diaSemana = diaSemana; }
}