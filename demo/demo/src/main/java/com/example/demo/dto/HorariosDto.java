package com.example.demo.dto;

import com.example.demo.model.enumeration.StatusHorario;
import java.time.LocalDateTime;

public class HorariosDto {
    private Long id;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Long usuarioId;          // agora identifica o usuário por id
    private Long estabelecimentoId;  // agora identifica o estabelecimento por id
    private LocalDateTime dataMarcacao;
    private StatusHorario statusHorario;

    public HorariosDto() {}

    public HorariosDto(Long id, LocalDateTime dataInicio, LocalDateTime dataFim, Long usuarioId, Long estabelecimentoId, LocalDateTime dataMarcacao, StatusHorario statusHorario) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.usuarioId = usuarioId;
        this.estabelecimentoId = estabelecimentoId;
        this.dataMarcacao = dataMarcacao;
        this.statusHorario = statusHorario;
    }

    public Long getId() { return id; }
    public LocalDateTime getDataInicio() { return dataInicio; }
    public LocalDateTime getDataFim() { return dataFim; }
    public Long getUsuarioId() { return usuarioId; }
    public Long getEstabelecimentoId() { return estabelecimentoId; }
    public LocalDateTime getDataMarcacao() { return dataMarcacao; }
    public StatusHorario getStatusHorario() { return statusHorario; }
}
