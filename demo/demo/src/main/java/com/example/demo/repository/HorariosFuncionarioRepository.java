package com.example.demo.repository;

import com.example.demo.model.HorariosFuncionario;
import com.example.demo.model.enumeration.StatusHorario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorariosFuncionarioRepository extends JpaRepository<HorariosFuncionario, Long> {

    HorariosFuncionario findByStatusHorario(StatusHorario statusHorario);
}
