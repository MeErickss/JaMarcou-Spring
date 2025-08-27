package com.example.demo.repository;

import com.example.demo.model.Categorias;
import com.example.demo.model.Estabelecimentos;
import com.example.demo.model.Horarios;
import com.example.demo.model.enumeration.StatusHorario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorariosRepository extends JpaRepository<Horarios, Long> {

    Horarios findByStatusHorario(StatusHorario statusHorario);
}
