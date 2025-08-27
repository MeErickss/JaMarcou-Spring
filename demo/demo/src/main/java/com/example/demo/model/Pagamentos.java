package com.example.demo.model;


import com.example.demo.model.enumeration.FormaPagamento;
import com.example.demo.model.enumeration.TipoPagamento;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pagamentos")
public class Pagamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String registro;

    @Column(nullable = false)
    private LocalDateTime data;

    @Column(nullable = false)
    private FormaPagamento formaPagamento;

    @Column(nullable = false)
    private Float valor;

    @Column(nullable = false)
    private TipoPagamento tipoPagamento;

    @OneToOne
    @JoinColumn(name = "horarios_id", referencedColumnName = "id", nullable = false)
    private Horarios horarios;

    public Pagamentos() {}

    public Pagamentos(Long id, String registro, LocalDateTime data, FormaPagamento formaPagamento, Float valor, TipoPagamento tipoPagamento, Horarios horarios) {
        this.id = id;
        this.registro = registro;
        this.data = data;
        this.formaPagamento = formaPagamento;
        this.valor = valor;
        this.tipoPagamento = tipoPagamento;
        this.horarios = horarios;
    }

    public Long getId() {return id;}
    public LocalDateTime getData() {return data;}
    public FormaPagamento getFormaPagamento() {return formaPagamento;}
    public String getRegistro() {return registro;}
    public Float getValor() {return valor;}
    public Horarios getHorario() {return horarios;}
    public TipoPagamento getTipoPagamento() {return tipoPagamento;}


    public void setData(LocalDateTime data) {this.data = data;}
    public void setFormaPagamento(FormaPagamento formaPagamento) {this.formaPagamento = formaPagamento;}
    public void setRegistro(String registro) {this.registro = registro;}
    public void setValor(Float valor) {this.valor = valor;}
    public void setHorario(Horarios horarios) {this.horarios = horarios;}
    public void setTipoPagamento(TipoPagamento tipoPagamento) {this.tipoPagamento = tipoPagamento;}
}
