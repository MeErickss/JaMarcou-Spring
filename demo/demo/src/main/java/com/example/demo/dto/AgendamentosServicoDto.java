package com.example.demo.dto;

import com.example.demo.model.AgendamentosServico;
import com.example.demo.model.enumeration.StatusHorario;

public class AgendamentosServicoDto {
    private Long id;
    private Long servicoId;
    private Long estabelecimentoId;
    private Long clienteId;
    private Long funcionarioId;
    private Long horarioId;
    private String observacoes;
    private StatusHorario status;

    public AgendamentosServicoDto(){}

    public AgendamentosServicoDto(Long id, Long servicoId, Long estabelecimentoId, Long clienteId, Long funcionarioId, Long horarioId, String observacoes, StatusHorario status){
        this.id = id;
        this.servicoId = servicoId;
        this.estabelecimentoId = estabelecimentoId;
        this.clienteId = clienteId;
        this.funcionarioId = funcionarioId;
        this.horarioId = horarioId;
        this.observacoes = observacoes;
        this.status = status;
    }

    public AgendamentosServicoDto(AgendamentosServico agendamento) {
        this.id = agendamento.getId();
        this.servicoId = agendamento.getServico() != null ? agendamento.getServico().getId() : null;
        this.estabelecimentoId = agendamento.getEstabelecimento() != null ? agendamento.getEstabelecimento().getId() : null;
        this.clienteId = agendamento.getCliente() != null ? agendamento.getCliente().getId() : null;
        this.funcionarioId = agendamento.getFuncionario() != null ? agendamento.getFuncionario().getId() : null;
        this.horarioId = agendamento.getHorario() != null ? agendamento.getHorario().getId() : null;
        this.observacoes = agendamento.getObservacoes();
    }

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
    public Long getHorarioId() { return horarioId; }
    public void setHorarioId(Long horarioId) { this.horarioId = horarioId; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
    public StatusHorario getStatus() { return status; }
    public void setStatus(StatusHorario status) { this.status = status; }
}
