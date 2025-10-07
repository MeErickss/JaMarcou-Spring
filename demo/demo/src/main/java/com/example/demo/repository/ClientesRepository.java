package com.example.demo.repository;

import com.example.demo.model.AgendamentosLocacao;
import com.example.demo.model.AgendamentosServico;
import com.example.demo.model.Clientes;
import com.example.demo.model.Estabelecimentos;
import com.example.demo.model.enumeration.StatusHorario;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {
    Clientes findByAgendamentosLocacao(AgendamentosLocacao agendamentosLocacao);
    Clientes findByAgendamentosServico(AgendamentosServico agendamentosServico);

    @EntityGraph(attributePaths = {}) // não carrega nenhuma relação
    @Query("SELECT e FROM Clientes e WHERE e.id = :id")
    Optional<Clientes> findBasicById(@Param("id") Long id);
}
