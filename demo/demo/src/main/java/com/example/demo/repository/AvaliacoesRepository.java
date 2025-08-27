package com.example.demo.repository;

import com.example.demo.model.Avaliacoes;
import com.example.demo.model.Servicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacoesRepository extends JpaRepository<Avaliacoes, Long> {

    Avaliacoes findByNota(Float nota);
}
