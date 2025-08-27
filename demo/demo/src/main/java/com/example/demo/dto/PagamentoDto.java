package com.example.demo.dto;

import com.example.demo.model.enumeration.FormaPagamento;
import com.example.demo.model.enumeration.TipoPagamento;

import java.time.LocalDateTime;

public class PagamentoDto {
    private Long id;
    private String registro;
    private LocalDateTime data;
    private FormaPagamento formaPagamento;
    private Float valor;
    private TipoPagamento tipoPagamento;
    private Long horarioId;

    public PagamentoDto() {}

    public PagamentoDto(Long id, String registro, LocalDateTime data, FormaPagamento formaPagamento, Float valor, TipoPagamento tipoPagamento, Long horarioId) {
        this.id = id;
        this.registro = registro;
        this.data = data;
        this.formaPagamento = formaPagamento;
        this.valor = valor;
        this.tipoPagamento = tipoPagamento;
        this.horarioId = horarioId;
    }

    public Long getId() { return id; }
    public String getRegistro() { return registro; }
    public LocalDateTime getData() { return data; }
    public FormaPagamento getFormaPagamento() { return formaPagamento; }
    public Float getValor() { return valor; }
    public TipoPagamento getTipoPagamento() { return tipoPagamento; }
    public Long getHorario() { return horarioId; }
}
