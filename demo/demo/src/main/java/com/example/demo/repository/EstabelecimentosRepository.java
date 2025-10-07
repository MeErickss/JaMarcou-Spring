package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstabelecimentosRepository extends JpaRepository<Estabelecimentos, Long> {
    @Query("SELECT e FROM Estabelecimentos e " +
            "JOIN AgendamentosLocacao a ON a.estabelecimento = e " +
            "WHERE a.id = :agendamentoId")
    Estabelecimentos findByAgendamentoLocacaoId(@Param("agendamentoId") Long agendamentoId);

    @Query("SELECT e FROM Estabelecimentos e " +
            "JOIN AgendamentosServico a ON a.estabelecimento = e " +
            "WHERE a.id = :agendamentoId")
    Estabelecimentos findByAgendamentoServicoId(@Param("agendamentoId") Long agendamentoId);

    Estabelecimentos findByFuncionarios(Funcionarios funcionarios);
    Estabelecimentos findByGerentes(Gerentes gerentes);
    Estabelecimentos findByServicos(Servicos servicos);
    Estabelecimentos findByLocacoes(Locacoes locacoes);

    @EntityGraph(attributePaths = {}) // não carrega nenhuma relação
    @Query("SELECT e FROM Estabelecimentos e WHERE e.id = :id")
    Optional<Estabelecimentos> findBasicById(@Param("id") Long id);
}
