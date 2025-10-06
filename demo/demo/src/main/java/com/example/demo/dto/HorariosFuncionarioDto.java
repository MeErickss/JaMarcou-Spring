package com.example.demo.dto;

import com.example.demo.model.enumeration.DiasSemana;
import com.example.demo.model.enumeration.StatusHorario;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class HorariosFuncionarioDto {
    private Long id;
    private Timestamp dataInicio;
    private Timestamp dataFim;
    private DiasSemana diaSemana;
    private Long usuarioId;
    private StatusHorario statusHorario;
    private LocalDateTime dataMarcacao;
    private Long estabelecimentoId;

    public HorariosFuncionarioDto() {}

    public HorariosFuncionarioDto(Long id, Timestamp dataInicio, Long estabelecimentoId, Timestamp dataFim, DiasSemana diaSemana, LocalDateTime dataMarcacao, Long usuarioId, StatusHorario statusHorario) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.diaSemana = diaSemana;
        this.usuarioId = usuarioId;
        this.statusHorario = statusHorario;
        this.dataMarcacao = dataMarcacao;
        this.estabelecimentoId = estabelecimentoId;
    }

    public Long getId() { return id; }
    public Timestamp getDataInicio() { return dataInicio; }
    public Timestamp getDataFim() { return dataFim; }
    public DiasSemana getDiaSemana() {return diaSemana;}
    public LocalDateTime getDataMarcacao() {return dataMarcacao;}
    public Long getUsuarioId() {return usuarioId;}
    public StatusHorario getStatusHorario() {return statusHorario;}
    public Long getEstabelecimentoId() {return estabelecimentoId;}
}
