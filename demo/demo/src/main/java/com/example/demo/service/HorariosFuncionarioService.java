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
public class HorariosFuncionarioService {

    @Autowired
    private HorariosFuncionarioRepository horariosFuncionarioRepository;

    @Autowired
    private EstabelecimentosRepository estabelecimentosRepository;

    @Autowired
    private FuncionariosRepository funcionariosRepository;

    /**
     * Cria horário para um funcionário (disponibilidade).
     */
    public HorariosFuncionario createHorarioFuncionario(StatusHorario statusHorario,
                                                        Timestamp dataInicio,
                                                        Timestamp dataFim,
                                                        LocalDateTime dataMarcacao,
                                                        Long estabelecimentoId,
                                                        Long funcionarioId,
                                                        DiasSemana diaSemana) {

        Estabelecimentos e = estabelecimentosRepository.findById(estabelecimentoId)
                .orElseThrow(() -> new IllegalArgumentException("Estabelecimento não encontrado: " + estabelecimentoId));
        Funcionarios f = funcionariosRepository.findById(funcionarioId)
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado: " + funcionarioId));

        HorariosFuncionario h = new HorariosFuncionario();
        h.setStatusHorario(statusHorario != null ? statusHorario : StatusHorario.LIVRE);
        h.setDataInicio(dataInicio);
        h.setDataFim(dataFim);
        h.setFuncionario(f); // campo ajustado para funcionario
        h.setDiaSemana(diaSemana);

        return horariosFuncionarioRepository.save(h);
    }
}
