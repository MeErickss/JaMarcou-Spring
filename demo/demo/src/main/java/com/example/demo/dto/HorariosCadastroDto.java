package com.example.demo.dto;

import com.example.demo.model.enumeration.DiasSemana;
import com.example.demo.model.enumeration.StatusHorario;

import java.sql.Timestamp;
import java.time.LocalDateTime;


public class HorariosCadastroDto {
    private Long id;
    private Timestamp dataInicio;
    private Timestamp dataFim;
    private DiasSemana diaSemana;

    public HorariosCadastroDto() {}

    public HorariosCadastroDto(Long id, Timestamp dataInicio, Long estabelecimentoId,Timestamp dataFim, DiasSemana diaSemana) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.diaSemana = diaSemana;
    }

    public Long getId() { return id; }
    public Timestamp getDataInicio() { return dataInicio; }
    public Timestamp getDataFim() { return dataFim; }
    public DiasSemana getDiaSemana() {return diaSemana;}
}
