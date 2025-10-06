package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.model.enumeration.FormaPagamento;
import com.example.demo.model.enumeration.StatusHorario;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AgendamentosLocacaoService {

    @Autowired
    private AgendamentosLocacaoRepository agendamentosLocacaoRepository;

    @Autowired
    private HorariosLocacaoRepository horariosLocacaoRepository;

    @Autowired
    private LocacoesRepository locacoesRepository;

    @Autowired
    private EstabelecimentosRepository estabelecimentosRepository;

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    public AgendamentosLocacao createAgendamentoLocacao(Long locacaoId,
                                                        Long horarioId,
                                                        Long clienteId,
                                                        LocalDateTime criadoEm,
                                                        StatusHorario statusHorario,
                                                        String observacoes,
                                                        BigDecimal valorPagamento,
                                                        FormaPagamento formaPagamento,
                                                        LocalDateTime dataPagamento,
                                                        Boolean pagamentoConfirmado) {

        Locacoes locacao = locacoesRepository.findById(locacaoId)
                .orElseThrow(() -> new IllegalArgumentException("Locação não encontrada: " + locacaoId));
        HorariosLocacao horario = horariosLocacaoRepository.findById(horarioId)
                .orElseThrow(() -> new IllegalArgumentException("Horário de locação não encontrado: " + horarioId));
        PessoaFisica cliente = pessoaFisicaRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado: " + clienteId));
        Estabelecimentos est = estabelecimentosRepository.findById(locacao.getEstabelecimento().getId())
                .orElseThrow(() -> new IllegalArgumentException("Estabelecimento não encontrado: " + locacao.getEstabelecimento().getId()));

        AgendamentosLocacao ag = new AgendamentosLocacao();
        ag.setLocacao(locacao);
        ag.setHorario(horario);
        ag.setCliente(cliente);
        ag.setEstabelecimento(est);
        ag.setObservacoes(observacoes);

        ag.setValorPagamento(valorPagamento);
        ag.setFormaPagamento(formaPagamento);
        ag.setDataPagamento(dataPagamento);
        ag.setPagamentoConfirmado(pagamentoConfirmado != null ? pagamentoConfirmado : Boolean.FALSE);

        AgendamentosLocacao salvo = agendamentosLocacaoRepository.save(ag);

        // marca horario como reservado
        horario.setStatusHorario(StatusHorario.AGENDADO);
        horariosLocacaoRepository.save(horario);

        return salvo;
    }
}
