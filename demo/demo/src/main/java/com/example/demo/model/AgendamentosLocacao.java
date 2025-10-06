package com.example.demo.model;

import com.example.demo.model.enumeration.FormaPagamento;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "agendamentos_locacao",
        indexes = {
                @Index(name = "idx_locacao_horario", columnList = "horario_id"),
                @Index(name = "idx_locacao_cliente", columnList = "cliente_id")
        }
)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AgendamentosLocacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // qual locacao (quadra/sala) está sendo alugada
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locacao_id", nullable = false)
    @JsonManagedReference(value = "locacao-agendamentos")
    private Locacoes locacao;

    // estabelecimento (redundante mas útil)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estabelecimento_id", nullable = false)
    @JsonManagedReference(value = "estabelecimento-agendamentos")
    private Estabelecimentos estabelecimento;

    // cliente
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    @JsonManagedReference(value = "cliente-agendamentos")
    private PessoaFisica cliente;

    // referencia ao horario de locacao
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "horario_id", nullable = false)
    @JsonManagedReference(value = "locacao-horario-agendamentos")
    private HorariosLocacao horario;

    @Column(name = "criado_em", nullable = false)
    private LocalDateTime criadoEm = LocalDateTime.now();

    @Column(length = 1000)
    private String observacoes;

    // pagamento
    @Column(name = "valor_pagamento", precision = 12, scale = 2, nullable = true)
    private BigDecimal valorPagamento;

    @Column(name = "metodo_pagamento", length = 100, nullable = true)
    private FormaPagamento formaPagamento;

    @Column(name = "data_pagamento", nullable = true)
    private LocalDateTime dataPagamento;

    @Column(name = "pagamento_confirmado", nullable = false)
    private Boolean pagamentoConfirmado = Boolean.FALSE;

    public AgendamentosLocacao() {}

    public AgendamentosLocacao(Locacoes locacao,
                               Estabelecimentos estabelecimento,
                               PessoaFisica cliente,
                               LocalDateTime criadoEm,
                               String observacoes,
                               HorariosLocacao horario,
                               BigDecimal valorPagamento,
                               FormaPagamento formaPagamento,
                               LocalDateTime dataPagamento,
                               Boolean pagamentoConfirmado) {
        this.estabelecimento = estabelecimento;
        this.cliente = cliente;
        this.locacao = locacao;
        this.horario = horario;
        this.criadoEm = criadoEm != null ? criadoEm : LocalDateTime.now();
        this.observacoes = observacoes;
        this.valorPagamento = valorPagamento;
        this.formaPagamento = formaPagamento;
        this.dataPagamento = dataPagamento;
        this.pagamentoConfirmado = pagamentoConfirmado != null ? pagamentoConfirmado : Boolean.FALSE;
    }

    public Long getId() {return id;}
    public LocalDateTime getCriadoEm() {return criadoEm;}

    public BigDecimal getValorPagamento() {return valorPagamento;}
    public void setValorPagamento(BigDecimal valorPagamento) {this.valorPagamento = valorPagamento;}

    public Boolean getPagamentoConfirmado() {return pagamentoConfirmado;}
    public void setPagamentoConfirmado(Boolean pagamentoConfirmado) {this.pagamentoConfirmado = pagamentoConfirmado;}

    public Estabelecimentos getEstabelecimento() {return estabelecimento;}
    public void setEstabelecimento(Estabelecimentos estabelecimento) {this.estabelecimento = estabelecimento;}

    public FormaPagamento getFormaPagamento() {return formaPagamento;}
    public void setFormaPagamento(FormaPagamento formaPagamento) {this.formaPagamento = formaPagamento;}

    public HorariosLocacao getHorario() {return horario;}
    public void setHorario(HorariosLocacao horario) {this.horario = horario;}

    public LocalDateTime getDataPagamento() {return dataPagamento;}
    public void setDataPagamento(LocalDateTime dataPagamento) {this.dataPagamento = dataPagamento;}

    public PessoaFisica getCliente() {return cliente;}
    public void setCliente(PessoaFisica cliente) {this.cliente = cliente;}

    public Locacoes getLocacao() {return locacao;}
    public void setLocacao(Locacoes locacao) {this.locacao = locacao;}

    public String getObservacoes() {return observacoes;}
    public void setObservacoes(String observacoes) {this.observacoes = observacoes;}
}


