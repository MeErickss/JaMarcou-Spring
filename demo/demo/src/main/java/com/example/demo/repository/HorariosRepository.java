package com.example.demo.repository;

import com.example.demo.model.Categorias;
import com.example.demo.model.Estabelecimentos;
import com.example.demo.model.Horarios;
import com.example.demo.model.enumeration.Funcoes;
import com.example.demo.model.enumeration.StatusHorario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorariosRepository extends JpaRepository<Horarios, Long> {

    Horarios findByStatusHorario(StatusHorario statusHorario);

    @Query("SELECT MIN(h.dataInicio), MAX(h.dataFim) FROM Horarios h WHERE h.estabelecimento.id = :estabId")
    Object[] findMinStartAndMaxEndByEstabelecimentoId(@Param("estabId") Long estabId);

    @Query("select distinct h from Horarios h " +
            "left join fetch h.usuario u " +
            "left join fetch h.estabelecimento e " +
            "left join fetch h.agendamentos a " +
            "left join fetch a.cliente ac " +      // opcional: traz cliente do agendamento
            "left join fetch a.funcionario af " +  // opcional: traz funcionario do agendamento
            "where h.estabelecimento.id = (" +
            "  select u2.estabelecimento.id from Usuarios u2 where u2.id = :userId" +
            ")")
    List<Horarios> findHorariosByEstabelecimentoOfUsuario(@Param("userId") Long userId);
}
