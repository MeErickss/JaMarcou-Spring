package com.example.demo.repository;

import com.example.demo.model.AgendamentosLocacao;
import com.example.demo.model.AgendamentosServico;
import com.example.demo.model.Clientes;
import com.example.demo.model.enumeration.StatusHorario;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AgendamentosServicoRepository extends JpaRepository<AgendamentosServico, Long> {
    List<AgendamentosServico> findByCliente(Clientes clientes);

    @EntityGraph(attributePaths = {}) // não carrega nenhuma relação
    @Query("SELECT e FROM AgendamentosServico e WHERE e.id = :id")
    Optional<AgendamentosServico> findBasicById(@Param("id") Long id);
}
