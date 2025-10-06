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
public class AgendamentosServicoService {

    @Autowired
    private AgendamentosServicoRepository agendamentosServicoRepository;

    @Autowired
    private ServicosRepository servicosRepository;

    @Autowired
    private EstabelecimentosRepository estabelecimentosRepository;

    @Autowired
    private HorariosFuncionarioRepository horariosFuncionarioRepository;

    @Autowired
    private FuncionariosRepository funcionariosRepository;

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    /**
     * Cria um agendamento de serviço (sem DTO) usando IDs e parâmetros diretos.
     * - servicoId, estabelecimentoId, clienteId, funcionarioId, horarioId são IDs esperados.
     * - valorPagamento/metodoPagamento/dataPagamento/pagamentoConfirmado são opcionais (pode passar null/false).
     */
    public AgendamentosServico createAgendamentoServico(Long servicoId,
                                                        Long estabelecimentoId,
                                                        Long clienteId,
                                                        Long funcionarioId,
                                                        Long horarioId,
                                                        String observacoes,
                                                        BigDecimal valorPagamento,
                                                        FormaPagamento formaPagamento,
                                                        LocalDateTime dataPagamento,
                                                        Boolean pagamentoConfirmado) {

        Servicos servico = servicosRepository.findById(servicoId)
                .orElseThrow(() -> new IllegalArgumentException("Serviço não encontrado: " + servicoId));
        Estabelecimentos est = estabelecimentosRepository.findById(estabelecimentoId)
                .orElseThrow(() -> new IllegalArgumentException("Estabelecimento não encontrado: " + estabelecimentoId));
        PessoaFisica cliente = pessoaFisicaRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado: " + clienteId));
        Funcionarios funcionario = funcionariosRepository.findById(funcionarioId)
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado: " + funcionarioId));
        HorariosFuncionario horario = horariosFuncionarioRepository.findById(horarioId)
                .orElseThrow(() -> new IllegalArgumentException("Horário não encontrado: " + horarioId));

        AgendamentosServico a = new AgendamentosServico();
        a.setServico(servico);
        a.setEstabelecimento(est);
        a.setCliente(cliente);
        a.setFuncionario(funcionario);
        a.setHorario(horario);
        a.setObservacoes(observacoes);

        a.setValorPagamento(valorPagamento);
        a.setFormaPagamento(formaPagamento);
        a.setDataPagamento(dataPagamento);
        a.setPagamentoConfirmado(pagamentoConfirmado != null ? pagamentoConfirmado : Boolean.FALSE);

        AgendamentosServico salvo = agendamentosServicoRepository.save(a);

        // marca horário como reservado (apenas uma ação simples; se quiser locking, implementar)
        horario.setStatusHorario(StatusHorario.AGENDADO);
        horariosFuncionarioRepository.save(horario);

        return salvo;
    }
}
