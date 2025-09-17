package com.example.demo.model;

import com.example.demo.model.enumeration.DiasSemana;
import com.example.demo.model.enumeration.StatusHorario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "horarios")
public class Horarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private DiasSemana diaSemana;

    @Column(nullable = false)
    private Timestamp dataInicio;

    @Column(nullable = false)
    private Timestamp dataFim;

    // campo 'usuario' representa qual usuário tem esse horário:
    @ManyToOne
    @JoinColumn(name = "usuarios_id", nullable = true)
    @JsonBackReference(value = "usuario-horario")
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "estabelecimentos_id", nullable = false)
    @JsonIgnore
    private Estabelecimentos estabelecimento;

    @Column(nullable = true)
    private LocalDateTime dataMarcacao;

    @Column(nullable = false)
    private StatusHorario statusHorario;

    // NOVO: agendamentos que usam este horario
    @OneToMany(mappedBy = "horario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference(value = "horario-agendamentos")
    private Set<Agendamentos> agendamentos = new HashSet<>();

    public Horarios() {}

    public Horarios(Long id, Timestamp dataInicio, Timestamp dataFim, DiasSemana diaSemana, Usuarios usuario, Estabelecimentos estabelecimento, LocalDateTime dataMarcacao, StatusHorario statusHorario) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.usuario = usuario;
        this.estabelecimento = estabelecimento;
        this.dataMarcacao = dataMarcacao;
        this.diaSemana = diaSemana;
        this.statusHorario = statusHorario;
    }

    public Long getId() { return id; }
    public Timestamp getDataFim() { return dataFim; }
    public Timestamp getDataInicio() { return dataInicio; }
    public LocalDateTime getDataMarcacao() { return dataMarcacao; }
    public Estabelecimentos getEstabelecimento() { return estabelecimento; }
    public StatusHorario getStatusHorario() { return statusHorario; }
    public Usuarios getUsuario() { return usuario; }
    public DiasSemana getDiaSemana() {return diaSemana;}

    // novos getters/setters
    public Set<Agendamentos> getAgendamentos() { return agendamentos; }
    public void setAgendamentos(Set<Agendamentos> agendamentos) { this.agendamentos = agendamentos; }

    public void setDataFim(Timestamp dataFim) { this.dataFim = dataFim; }
    public void setDataInicio(Timestamp dataInicio) { this.dataInicio = dataInicio; }
    public void setDataMarcacao(LocalDateTime dataMarcacao) { this.dataMarcacao = dataMarcacao; }
    public void setEstabelecimento(Estabelecimentos estabelecimento) { this.estabelecimento = estabelecimento; }
    public void setStatusHorario(StatusHorario statusHorario) { this.statusHorario = statusHorario; }
    public void setUsuario(Usuarios usuario) { this.usuario = usuario; }
    public void setDiaSemana(DiasSemana diaSemana) {this.diaSemana = diaSemana;}
}
