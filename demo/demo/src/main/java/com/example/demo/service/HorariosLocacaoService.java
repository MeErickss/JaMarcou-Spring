package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.model.enumeration.DiasSemana;
import com.example.demo.model.enumeration.StatusHorario;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class HorariosLocacaoService {

    @Autowired
    private HorariosLocacaoRepository horariosLocacaoRepository;

    @Autowired
    private LocacoesRepository locacoesRepository;

    /**
     * Cria horário disponível para uma locação (quadra/sala).
     */
    public HorariosLocacao createHorarioLocacao(DiasSemana diaSemana,
                                                Timestamp dataInicio,
                                                Timestamp dataFim,
                                                Long locacaoId,
                                                LocalDateTime dataCriacao,
                                                StatusHorario statusHorario) {

        Locacoes loc = locacoesRepository.findById(locacaoId)
                .orElseThrow(() -> new IllegalArgumentException("Locação não encontrada: " + locacaoId));

        HorariosLocacao h = new HorariosLocacao();
        h.setDiaSemana(diaSemana);
        h.setDataInicio(dataInicio);
        h.setDataFim(dataFim);
        h.setLocacao(loc);
        h.setDataCriacao(dataCriacao != null ? dataCriacao : LocalDateTime.now());
        h.setStatusHorario(statusHorario != null ? statusHorario : StatusHorario.LIVRE);

        return horariosLocacaoRepository.save(h);
    }
}
