package com.example.demo.model;

import com.example.demo.model.enumeration.StatusHorario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

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
    private LocalDateTime dataInicio;

    @Column(nullable = false)
    private LocalDateTime dataFim;

    // campo 'usuario' representa qual usuário tem esse horário:
    @ManyToOne
    @JoinColumn(name = "usuarios_id", nullable = false)
    @JsonBackReference(value = "usuario-horario")
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "estabelecimentos_id", nullable = false)
    @JsonIgnore
    private Estabelecimentos estabelecimento;

    @Column(nullable = false)
    private LocalDateTime dataMarcacao;

    @Column(nullable = false)
    private StatusHorario statusHorario;

    // NOVO: agendamentos que usam este horario
    @OneToMany(mappedBy = "horario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference(value = "horario-agendamentos")
    private Set<Agendamentos> agendamentos = new HashSet<>();

    public Horarios() {}

    public Horarios(Long id, LocalDateTime dataInicio, LocalDateTime dataFim, Usuarios usuario, Estabelecimentos estabelecimento, LocalDateTime dataMarcacao, StatusHorario statusHorario) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.usuario = usuario;
        this.estabelecimento = estabelecimento;
        this.dataMarcacao = dataMarcacao;
        this.statusHorario = statusHorario;
    }

    public Long getId() { return id; }
    public LocalDateTime getDataFim() { return dataFim; }
    public LocalDateTime getDataInicio() { return dataInicio; }
    public LocalDateTime getDataMarcacao() { return dataMarcacao; }
    public Estabelecimentos getEstabelecimento() { return estabelecimento; }
    public StatusHorario getStatusHorario() { return statusHorario; }
    public Usuarios getUsuario() { return usuario; }

    // novos getters/setters
    public Set<Agendamentos> getAgendamentos() { return agendamentos; }
    public void setAgendamentos(Set<Agendamentos> agendamentos) { this.agendamentos = agendamentos; }

    public void setDataFim(LocalDateTime dataFim) { this.dataFim = dataFim; }
    public void setDataInicio(LocalDateTime dataInicio) { this.dataInicio = dataInicio; }
    public void setDataMarcacao(LocalDateTime dataMarcacao) { this.dataMarcacao = dataMarcacao; }
    public void setEstabelecimento(Estabelecimentos estabelecimento) { this.estabelecimento = estabelecimento; }
    public void setStatusHorario(StatusHorario statusHorario) { this.statusHorario = statusHorario; }
    public void setUsuario(Usuarios usuario) { this.usuario = usuario; }
}
