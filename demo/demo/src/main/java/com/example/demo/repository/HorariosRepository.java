package com.example.demo.repository;

import com.example.demo.model.Categorias;
import com.example.demo.model.Estabelecimentos;
import com.example.demo.model.Horarios;
import com.example.demo.model.enumeration.StatusHorario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HorariosRepository extends JpaRepository<Horarios, Long> {

    Horarios findByStatusHorario(StatusHorario statusHorario);

    @Query("SELECT MIN(h.dataInicio), MAX(h.dataFim) FROM Horarios h WHERE h.estabelecimento.id = :estabId")
    Object[] findMinStartAndMaxEndByEstabelecimentoId(@Param("estabId") Long estabId);
}
