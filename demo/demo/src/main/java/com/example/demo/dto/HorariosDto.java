package com.example.demo.dto;

import com.example.demo.model.enumeration.StatusHorario;

import java.time.LocalDateTime;

public class HorariosDto {
    private Long id;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String usuarioEmail;
    private String estabelecimentoNome;
    private LocalDateTime dataMarcacao;
    private StatusHorario statusHorario;

    public HorariosDto() {}

    public HorariosDto(Long id, LocalDateTime dataInicio, LocalDateTime dataFim, String usuarioEmail, String estabelecimentoNome, LocalDateTime dataMarcacao, StatusHorario statusHorario) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.usuarioEmail = usuarioEmail;
        this.estabelecimentoNome = estabelecimentoNome;
        this.dataMarcacao = dataMarcacao;
        this.statusHorario = statusHorario;
    }

    public Long getId() { return id; }
    public LocalDateTime getDataInicio() { return dataInicio; }
    public LocalDateTime getDataFim() { return dataFim; }
    public String getUsuarioId() { return usuarioEmail; }
    public String getEstabelecimentoId() { return estabelecimentoNome; }
    public LocalDateTime getDataMarcacao() { return dataMarcacao; }
    public StatusHorario getStatusHorario() { return statusHorario; }
}
