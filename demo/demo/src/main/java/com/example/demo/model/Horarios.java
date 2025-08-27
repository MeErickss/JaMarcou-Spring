package com.example.demo.model;

import com.example.demo.model.enumeration.StatusHorario;
import jakarta.persistence.*;

import java.time.LocalDateTime;

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

    @ManyToOne
    @JoinColumn(name = "usuarios_id", nullable = false)
    private Usuarios usuarios;

    @ManyToOne
    @JoinColumn(name = "estabelecimentos_id", nullable = false)
    private Estabelecimentos estabelecimento;

    @Column(nullable = false)
    private LocalDateTime dataMarcacao;

    @Column(nullable = false)
    private StatusHorario statusHorario;

    public Horarios() {}

    public Horarios(Long id, LocalDateTime dataInicio, LocalDateTime dataFim, Usuarios usuarios, Estabelecimentos estabelecimento, LocalDateTime dataMarcacao, StatusHorario statusHorario) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.usuarios = usuarios;
        this.estabelecimento = estabelecimento;
        this.dataMarcacao = dataMarcacao;
        this.statusHorario = statusHorario;
    }

    public LocalDateTime getDataFim() {return dataFim;}
    public LocalDateTime getDataInicio() {return dataInicio;}
    public LocalDateTime getDataMarcacao() {return dataMarcacao;}
    public Estabelecimentos getEstabelecimento() {return estabelecimento;}
    public StatusHorario getStatusHorario() {return statusHorario;}
    public Usuarios getUsuario() {return usuarios;}


    public void setDataFim(LocalDateTime dataFim) {this.dataFim = dataFim;}
    public void setDataInicio(LocalDateTime dataInicio) {this.dataInicio = dataInicio;}
    public void setDataMarcacao(LocalDateTime dataMarcacao) {this.dataMarcacao = dataMarcacao;}
    public void setEstabelecimento(Estabelecimentos estabelecimento) {this.estabelecimento = estabelecimento;}
    public void setStatusHorario(StatusHorario statusHorarioId) {this.statusHorario = statusHorarioId;}
    public void setUsuario(Usuarios usuarios) {this.usuarios = usuarios;}
}
