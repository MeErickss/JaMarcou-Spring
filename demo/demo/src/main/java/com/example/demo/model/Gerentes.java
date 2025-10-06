package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "gerentes")
@DiscriminatorValue("GERENTE")
@PrimaryKeyJoinColumn(name = "id")
public class Gerentes extends PessoaFisica {

    @Column(name = "data_inicio_contrato")
    private LocalDateTime dataInicioContrato;

    @Column(name = "data_fim_contrato")
    private LocalDateTime dataFimContrato;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "estabelecimento_id")
    @JsonBackReference(value = "estabelecimento-gerentes")
    private Estabelecimentos estabelecimento;

    public Gerentes() { super(); }

    public Gerentes(Long id, String nome, String email, String sobrenome, String cpf, String senha,
                    LocalDateTime dataNascimento, String linkImagem, String statusUsuario,
                    Estabelecimentos estabelecimento, String telefone) {
        super(id, nome, email, sobrenome, cpf, senha, dataNascimento, linkImagem, statusUsuario, telefone);
        this.estabelecimento = estabelecimento;
    }

    public Estabelecimentos getEstabelecimento() { return estabelecimento; }
    public void setEstabelecimento(Estabelecimentos estabelecimento) { this.estabelecimento = estabelecimento; }

}