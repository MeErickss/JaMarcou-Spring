package com.example.demo.model;

import com.example.demo.model.enumeration.FormaPagamento;
import com.example.demo.model.enumeration.StatusHorario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "agendamentos_servico",
        indexes = {
                @Index(name = "idx_agendamento_horario", columnList = "horario_id"),
                @Index(name = "idx_agendamento_funcionario", columnList = "funcionario_id"),
                @Index(name = "idx_agendamento_cliente", columnList = "cliente_id")
        }
)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AgendamentosServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // serviço agendado
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servico_id", nullable = false)
    @JsonManagedReference(value = "servico-agendamentos")
    private Servicos servico;

    // estabelecimento
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estabelecimento_id", nullable = false)
    @JsonManagedReference(value = "estabelecimento-agendamentos")
    private Estabelecimentos estabelecimento;

    // cliente (quem marcou)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    @JsonManagedReference(value = "cliente-agendamentos")
    private PessoaFisica cliente;

    // funcionário que irá atender (deve ser do tipo Funcionarios)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "funcionario_id", nullable = false)
    @JsonManagedReference(value = "funcionario-agendamentos")
    private Funcionarios funcionario;

    // referência ao Horario de onde vem dataInicio/dataFim
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "horario_id", nullable = false)
    @JsonManagedReference(value = "horario-agendamentos")
    private HorariosFuncionario horario;

    @Column(name = "criado_em", nullable = false)
    private LocalDateTime criadoEm = LocalDateTime.now();

    @Column(length = 1000)
    private String observacoes;

    // === CAMPOS DE PAGAMENTO ===
    @Column(name = "valor_pagamento", precision = 12, scale = 2, nullable = true)
    private BigDecimal valorPagamento;

    @Column(name = "metodo_pagamento", length = 100, nullable = true)
    private FormaPagamento formaPagamento; // ex: "CARD", "PIX", "DINHEIRO"

    @Column(name = "data_pagamento", nullable = true)
    private LocalDateTime dataPagamento;

    @Column(name = "pagamento_confirmado", nullable = false)
    private Boolean pagamentoConfirmado = Boolean.FALSE;

    public AgendamentosServico() {}

    // construtor reduzido; getters/setters omitidos por brevidade
    public AgendamentosServico(Servicos servico,
                               Estabelecimentos estabelecimento,
                               PessoaFisica cliente,
                               Funcionarios funcionario,
                               HorariosFuncionario horario,
                               LocalDateTime criadoEm,
                               String observacoes,
                               BigDecimal valorPagamento,
                               FormaPagamento formaPagamento,
                               LocalDateTime dataPagamento,
                               Boolean pagamentoConfirmado) {
        this.servico = servico;
        this.estabelecimento = estabelecimento;
        this.cliente = cliente;
        this.funcionario = funcionario;
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

    public Funcionarios getFuncionario() {return funcionario;}
    public void setFuncionario(Funcionarios funcionario) {this.funcionario = funcionario;}

    public HorariosFuncionario getHorario() {return horario;}
    public void setHorario(HorariosFuncionario horario) {this.horario = horario;}

    public LocalDateTime getDataPagamento() {return dataPagamento;}
    public void setDataPagamento(LocalDateTime dataPagamento) {this.dataPagamento = dataPagamento;}

    public PessoaFisica getCliente() {return cliente;}
    public void setCliente(PessoaFisica cliente) {this.cliente = cliente;}

    public Servicos getServico() {return servico;}
    public void setServico(Servicos servico) {this.servico = servico;}

    public String getObservacoes() {return observacoes;}
    public void setObservacoes(String observacoes) {this.observacoes = observacoes;}
}

