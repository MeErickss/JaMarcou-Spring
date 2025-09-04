package com.example.demo.model;

import com.example.demo.model.enumeration.StatusHorario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "agendamentos",
        indexes = {
                @Index(name = "idx_agendamento_funcionario_inicio", columnList = "funcionario_id, data_inicio"),
                @Index(name = "idx_agendamento_cliente", columnList = "cliente_id")
        }
)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Agendamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // serviço agendado
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servico_id", nullable = false)
    private Servicos servico;

    // estabelecimento
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estabelecimento_id", nullable = false)
    private Estabelecimentos estabelecimento;

    // cliente (quem marcou)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Usuarios cliente;

    // funcionário que irá atender (também usuário)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "funcionario_id", nullable = false)
    private Usuarios funcionario;

    @Column(name = "data_inicio", nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "data_fim", nullable = false)
    private LocalDateTime dataFim;

    @Column(name = "criado_em", nullable = false)
    private LocalDateTime criadoEm = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusHorario status = StatusHorario.LIVRE;

    @Column(length = 1000)
    private String observacoes;


    public Agendamentos() {}

    public Agendamentos(Servicos servico, Estabelecimentos estabelecimento, Usuarios cliente, Usuarios funcionario,
                        LocalDateTime dataInicio, LocalDateTime dataFim, LocalDateTime criadoEm,
                        StatusHorario status, String observacoes) {
        this.servico = servico;
        this.estabelecimento = estabelecimento;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.criadoEm = criadoEm != null ? criadoEm : LocalDateTime.now();
        this.status = status != null ? status : StatusHorario.LIVRE;
        this.observacoes = observacoes;
    }

    public Long getId(){return id;} public void setId(Long id){this.id = id;}
    public Servicos getServico(){return servico;} public void setServico(Servicos servico){this.servico = servico;}
    public Estabelecimentos getEstabelecimento(){return estabelecimento;} public void setEstabelecimento(Estabelecimentos estabelecimento){this.estabelecimento = estabelecimento;}
    public Usuarios getCliente(){return cliente;} public void setCliente(Usuarios cliente){this.cliente = cliente;}
    public Usuarios getFuncionario(){return funcionario;} public void setFuncionario(Usuarios funcionario){this.funcionario = funcionario;}
    public LocalDateTime getDataInicio(){return dataInicio;} public void setDataInicio(LocalDateTime dataInicio){this.dataInicio = dataInicio;}
    public LocalDateTime getDataFim(){return dataFim;} public void setDataFim(LocalDateTime dataFim){this.dataFim = dataFim;}
    public LocalDateTime getCriadoEm(){return criadoEm;} public void setCriadoEm(LocalDateTime criadoEm){this.criadoEm = criadoEm;}
    public StatusHorario getStatus(){return status;} public void setStatus(StatusHorario status){this.status = status;}
    public String getObservacoes(){return observacoes;} public void setObservacoes(String observacoes){this.observacoes = observacoes;}
}
