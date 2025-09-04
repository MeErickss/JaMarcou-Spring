package com.example.demo.repository;

import com.example.demo.model.Agendamentos;
import com.example.demo.model.enumeration.StatusHorario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AgendamentosRepository extends JpaRepository<Agendamentos, Long> {

    List<Agendamentos> findByStatus(StatusHorario status);

}
