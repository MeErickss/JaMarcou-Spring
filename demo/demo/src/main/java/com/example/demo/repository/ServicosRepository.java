package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServicosRepository extends JpaRepository<Servicos, Long> {
    @Query("SELECT s FROM Servicos s JOIN AgendamentosServico a ON a.servico = s WHERE a = :agendamento")
    List<Servicos> findByAgendamentoServico(@Param("agendamento") AgendamentosServico agendamento);
    List<Servicos> findByEstabelecimento(Estabelecimentos estabelecimentos);

    @EntityGraph(attributePaths = {}) // não carrega nenhuma relação
    @Query("SELECT e FROM Servicos e WHERE e.id = :id")
    Optional<Servicos> findBasicById(@Param("id") Long id);
}
