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
public interface HorariosFuncionarioRepository extends JpaRepository<HorariosFuncionario, Long> {
    @Query("SELECT h FROM HorariosFuncionario h " +
            "JOIN AgendamentosServico a ON a.horario = h " +
            "WHERE a.id = :agendamentoId")
    HorariosFuncionario findByAgendamentosServicoId(@Param("agendamentoId") Long agendamentoId);
    List<HorariosFuncionario> findByFuncionario(Funcionarios funcionarios);

    @EntityGraph(attributePaths = {}) // não carrega nenhuma relação
    @Query("SELECT e FROM HorariosFuncionario e WHERE e.id = :id")
    Optional<HorariosFuncionario> findBasicById(@Param("id") Long id);
}
