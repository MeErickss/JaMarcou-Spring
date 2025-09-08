package com.example.demo.model;

import com.example.demo.model.enumeration.StatusHorario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "agendamentos",
        indexes = {
                @Index(name = "idx_agendamento_horario", columnList = "horario_id"),
                @Index(name = "idx_agendamento_funcionario", columnList = "funcionario_id"),
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
    private Usuarios cliente;

    // funcionário que irá atender (também usuário)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "funcionario_id", nullable = false)
    @JsonManagedReference(value = "funcionario-agendamentos")
    private Usuarios funcionario;

    // referência ao Horario de onde vem dataInicio/dataFim
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "horario_id", nullable = false)
    @JsonManagedReference(value = "horario-agendamentos")
    private Horarios horario;

    @Column(name = "criado_em", nullable = false)
    private LocalDateTime criadoEm = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusHorario status = StatusHorario.LIVRE;

    @Column(length = 1000)
    private String observacoes;

    public Agendamentos() {}

    public Agendamentos(Servicos servico, Estabelecimentos estabelecimento, Usuarios cliente, Usuarios funcionario,
                        Horarios horario, LocalDateTime criadoEm,
                        StatusHorario status, String observacoes) {
        this.servico = servico;
        this.estabelecimento = estabelecimento;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.horario = horario;
        this.criadoEm = criadoEm != null ? criadoEm : LocalDateTime.now();
        this.status = status != null ? status : StatusHorario.LIVRE;
        this.observacoes = observacoes;
    }

    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }

    public Servicos getServico(){ return servico; }
    public void setServico(Servicos servico){ this.servico = servico; }

    public Estabelecimentos getEstabelecimento(){ return estabelecimento; }
    public void setEstabelecimento(Estabelecimentos estabelecimento){ this.estabelecimento = estabelecimento; }

    public Usuarios getCliente(){ return cliente; }
    public void setCliente(Usuarios cliente){ this.cliente = cliente; }

    public Usuarios getFuncionario(){ return funcionario; }
    public void setFuncionario(Usuarios funcionario){ this.funcionario = funcionario; }

    public Horarios getHorario(){ return horario; }
    public void setHorario(Horarios horario){ this.horario = horario; }

    public LocalDateTime getCriadoEm(){ return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm){ this.criadoEm = criadoEm; }

    public StatusHorario getStatus(){ return status; }
    public void setStatus(StatusHorario status){ this.status = status; }

    public String getObservacoes(){ return observacoes; }
    public void setObservacoes(String observacoes){ this.observacoes = observacoes; }
}
