package com.example.demo.repository;

import com.example.demo.model.AgendamentosLocacao;
import com.example.demo.model.Clientes;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AgendamentosLocacaoRepository extends JpaRepository<AgendamentosLocacao, Long> {
    List<AgendamentosLocacao> findByCliente(Clientes clientes);

    @EntityGraph(attributePaths = {}) // não carrega relações
    @Query("SELECT a FROM AgendamentosLocacao a WHERE a.id = :id")
    Optional<AgendamentosLocacao> findBasicById(@Param("id") Long id);
}
