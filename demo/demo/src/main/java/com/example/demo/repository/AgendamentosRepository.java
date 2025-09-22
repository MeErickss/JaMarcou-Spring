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

    @Query("SELECT DISTINCT a FROM Agendamentos a " +
            "LEFT JOIN FETCH a.servico s " +
            "LEFT JOIN FETCH a.estabelecimento e " +
            "LEFT JOIN FETCH a.horario h " +
            "LEFT JOIN FETCH a.cliente c " +
            "LEFT JOIN FETCH a.funcionario f " +
            "WHERE a.cliente.id = :userId OR a.funcionario.id = :userId")
    List<Agendamentos> findByUsuarioId(@Param("userId") Long userId);

    @Query("SELECT DISTINCT a FROM Agendamentos a " +
            "JOIN FETCH a.servico s " +
            "JOIN FETCH a.estabelecimento e " +
            "JOIN FETCH a.horario h " +
            "LEFT JOIN FETCH a.cliente c " +
            "LEFT JOIN FETCH a.funcionario f " +
            "JOIN e.usuarios u " +
            "WHERE u.id = :managerId")
    List<Agendamentos> findAllByGerenteId(@Param("managerId") Long managerId);

}
