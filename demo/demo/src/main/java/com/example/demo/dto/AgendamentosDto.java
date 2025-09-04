package com.example.demo.dto;

import com.example.demo.model.enumeration.StatusHorario;

import java.time.LocalDateTime;

public class AgendamentosDto {
    private Long id;
    private Long servicoId;
    private Long estabelecimentoId;
    private Long clienteId;
    private Long funcionarioId;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String observacoes;
    private StatusHorario status;

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getServicoId() { return servicoId; }
    public void setServicoId(Long servicoId) { this.servicoId = servicoId; }
    public Long getEstabelecimentoId() { return estabelecimentoId; }
    public void setEstabelecimentoId(Long estabelecimentoId) { this.estabelecimentoId = estabelecimentoId; }
    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
    public Long getFuncionarioId() { return funcionarioId; }
    public void setFuncionarioId(Long funcionarioId) { this.funcionarioId = funcionarioId; }
    public LocalDateTime getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDateTime dataInicio) { this.dataInicio = dataInicio; }
    public LocalDateTime getDataFim() { return dataFim; }
    public void setDataFim(LocalDateTime dataFim) { this.dataFim = dataFim; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
    public StatusHorario getStatus() { return status; }
    public void setStatus(StatusHorario status) { this.status = status; }
}
