package com.example.demo.repository;

import com.example.demo.model.*;
import com.example.demo.model.enumeration.StatusHorario;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocacoesRepository extends JpaRepository<Locacoes, Long> {
    List<Locacoes> findByEstabelecimento(Estabelecimentos estabelecimentos);
    @Query("SELECT l FROM Locacoes l " +
            "JOIN AgendamentosLocacao a ON a.locacao = l " +
            "WHERE a.id = :agendamentoId")
    List<Locacoes> findByAgendamentoLocacaoId(@Param("agendamentoId") Long agendamentoId);    List<Locacoes> findByHorariosLocacao(HorariosLocacao horariosLocacao);

    @EntityGraph(attributePaths = {}) // não carrega nenhuma relação
    @Query("SELECT e FROM Locacoes e WHERE e.id = :id")
    Optional<Locacoes> findBasicById(@Param("id") Long id);

}
