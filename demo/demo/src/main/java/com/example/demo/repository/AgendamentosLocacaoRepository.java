package com.example.demo.repository;

import com.example.demo.model.AgendamentosLocacao;
import com.example.demo.model.AgendamentosServico;
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

    @Query("""
        select a 
        from AgendamentosLocacao a
        join fetch a.estabelecimento e
        left join fetch a.cliente c
        left join fetch a.horario h
        where e.id = (
           select g.estabelecimento.id from Gerentes g where g.id = :gerenteId
        )
        """)
    List<AgendamentosLocacao> findAllByGerenteEstabelecimento(@Param("gerenteId") Long gerenteId);

    @EntityGraph(attributePaths = {}) // não carrega relações
    @Query("SELECT a FROM AgendamentosLocacao a WHERE a.id = :id")
    Optional<AgendamentosLocacao> findBasicById(@Param("id") Long id);
}
