package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "funcionarios")
@DiscriminatorValue("FUNCIONARIO")
@PrimaryKeyJoinColumn(name = "id")
public class Funcionarios extends PessoaFisica {

    @Column(name = "data_inicio_contrato")
    private LocalDateTime dataInicioContrato;

    @Column(name = "data_fim_contrato")
    private LocalDateTime dataFimContrato;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "estabelecimento_id")
    @JsonBackReference(value = "estabelecimento-funcionarios")
    private Estabelecimentos estabelecimento;

    @OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "funcionario-horario")
    private Set<HorariosFuncionario> horarios = new HashSet<>();

    public Funcionarios() {
        super();
    }

    public Funcionarios(Long id,
                        String nome, String email, String sobrenome, String cpf, String senha, LocalDateTime dataNascimento,
                        String linkImagem, String statusUsuario, LocalDateTime dataInicioContrato, LocalDateTime dataFimContrato,
                        Estabelecimentos estabelecimento, String telefone, Set<HorariosFuncionario> horarios) {

        super(id, nome, email, sobrenome, cpf, senha, dataNascimento, linkImagem, statusUsuario, telefone);
        this.dataInicioContrato = dataInicioContrato;
        this.dataFimContrato = dataFimContrato;
        this.estabelecimento = estabelecimento;
        this.horarios = horarios;
    }

    public LocalDateTime getDataInicioContrato() { return dataInicioContrato; }
    public void setDataInicioContrato(LocalDateTime dataInicioContrato) { this.dataInicioContrato = dataInicioContrato; }

    public LocalDateTime getDataFimContrato() { return dataFimContrato; }
    public void setDataFimContrato(LocalDateTime dataFimContrato) { this.dataFimContrato = dataFimContrato; }

    public Estabelecimentos getEstabelecimento() { return estabelecimento; }
    public void setEstabelecimento(Estabelecimentos estabelecimento) { this.estabelecimento = estabelecimento; }

    public Set<HorariosFuncionario> getHorarios() {return horarios;}
    public void setHorarios(Set<HorariosFuncionario> horarios) {this.horarios = horarios;}
}
