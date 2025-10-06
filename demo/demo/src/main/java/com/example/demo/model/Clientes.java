package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clientes")
@DiscriminatorValue("CLIENTE")
@PrimaryKeyJoinColumn(name = "id")
public class Clientes extends PessoaFisica {

    // coleções de agendamentos (serviço e locação) onde este cliente participou
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference(value = "cliente-agendamentos")
    private Set<AgendamentosServico> agendamentosServico = new HashSet<>();

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference(value = "cliente-agendamentos")
    private Set<AgendamentosLocacao> agendamentosLocacao = new HashSet<>();

    public Clientes() { super(); }

    // construtor útil se quiser inicializar via código
    public Clientes(Long id, String nome, String email, String sobrenome, String cpf, String telefone,
                    String senha, java.time.LocalDateTime dataNascimento, String linkImagem, String statusUsuario) {
        super(id, nome, email, sobrenome, cpf, senha, dataNascimento, linkImagem, statusUsuario, telefone);
    }

    // getters / setters
    public Set<AgendamentosServico> getAgendamentosServico() { return agendamentosServico; }
    public void setAgendamentosServico(Set<AgendamentosServico> agendamentosServico) { this.agendamentosServico = agendamentosServico; }

    public Set<AgendamentosLocacao> getAgendamentosLocacao() { return agendamentosLocacao; }
    public void setAgendamentosLocacao(Set<AgendamentosLocacao> agendamentosLocacao) { this.agendamentosLocacao = agendamentosLocacao; }

}
