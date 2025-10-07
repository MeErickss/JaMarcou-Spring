package com.example.demo.repository;


import com.example.demo.model.Estabelecimentos;
import com.example.demo.model.Gerentes;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GerentesRepository extends JpaRepository<Gerentes, Long> {
    List<Gerentes> findByEstabelecimento(Estabelecimentos estabelecimentos);

    @Query("select f.dataInicioContrato, f.dataFimContrato from Gerentes f where f.id = :id")
    Optional<Object[]> findContractDatesById(@Param("id") Long id);

    @EntityGraph(attributePaths = {}) // não carrega nenhuma relação
    @Query("SELECT e FROM Gerentes e WHERE e.id = :id")
    Optional<Gerentes> findBasicById(@Param("id") Long id);
}
