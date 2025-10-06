package com.example.demo.repository;

import com.example.demo.model.AgendamentosServico;
import com.example.demo.model.Locacoes;
import com.example.demo.model.enumeration.StatusHorario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocacoesRepository extends JpaRepository<Locacoes, Long> {


}
