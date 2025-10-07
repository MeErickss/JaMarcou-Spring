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
public interface HorariosLocacaoRepository extends JpaRepository<HorariosLocacao, Long> {
    @Query("SELECT h FROM HorariosLocacao h " +
            "JOIN AgendamentosLocacao a ON a.horario = h " +
            "WHERE a.id = :agendamentoId")
    List<HorariosLocacao> findByAgendamentoLocacaoId(@Param("agendamentoId") Long agendamentoId);
    List<HorariosLocacao> findByLocacao(Locacoes locacoes);

    @EntityGraph(attributePaths = {}) // não carrega nenhuma relação
    @Query("SELECT e FROM HorariosLocacao e WHERE e.id = :id")
    Optional<HorariosLocacao> findBasicById(@Param("id") Long id);

}
