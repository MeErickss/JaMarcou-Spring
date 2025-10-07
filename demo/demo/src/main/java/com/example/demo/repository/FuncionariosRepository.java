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
public interface FuncionariosRepository extends JpaRepository<Funcionarios, Long> {
    List<Funcionarios> findByEstabelecimento(Estabelecimentos estabelecimentos);
    @Query("""
    SELECT s.prestador 
    FROM Servicos s
    JOIN AgendamentosServico a ON a.servico.id = s.id
    WHERE a.id = :agendamentoServicoId
""")
    Funcionarios findFuncionarioByAgendamentoServico(@Param("agendamentoServicoId") Long agendamentoServicoId);
    List<Funcionarios> findByHorariosFuncionario(HorariosFuncionario horariosFuncionario);
    @Query("SELECT s.prestador FROM Servicos s WHERE s.id = :servicoId")
    List<Funcionarios> findFuncionariosByServicosId(@Param("servicoId") Long servicoId);


    @Query("select f.dataInicioContrato, f.dataFimContrato from Funcionarios f where f.id = :id")
    Optional<Object[]> findContractDatesById(@Param("id") Long id);

    @EntityGraph(attributePaths = {}) // não carrega nenhuma relação
    @Query("SELECT e FROM Funcionarios e WHERE e.id = :id")
    Optional<Funcionarios> findBasicById(@Param("id") Long id);
}
