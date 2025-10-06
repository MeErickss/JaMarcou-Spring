package com.example.demo.service;

import com.example.demo.dto.PagamentoDto;
import com.example.demo.model.HorariosFuncionario;
import com.example.demo.model.Pagamentos;
import com.example.demo.model.enumeration.FormaPagamento;
import com.example.demo.model.enumeration.TipoPagamento;
import com.example.demo.repository.HorariosFuncionarioRepository;
import com.example.demo.repository.PagamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PagamentosService {

    @Autowired
    private PagamentosRepository pagamentosRepository;

    @Autowired
    private HorariosFuncionarioRepository horariosFuncionarioRepository;

    // Listar todos
    public List<Pagamentos> listAllPagamentos() {
        return pagamentosRepository.findAll();
    }

    // Buscar por ID
    public Optional<Pagamentos> getPagamentoById(Long id) {
        if (id == null) return Optional.empty();
        return pagamentosRepository.findById(id);
    }

    // Cadastro usando parâmetros
    public void cadastrarPagamentos(FormaPagamento formaPagamento, Long horarioId, TipoPagamento tipoPagamento, Float valor, LocalDateTime data, String registro){
        HorariosFuncionario h = null;
        if (horarioId != null) {
            h = horariosFuncionarioRepository.findById(horarioId)
                    .orElseThrow(() -> new IllegalArgumentException("Horário não encontrado: " + horarioId));
        }

        Pagamentos pagamento = new Pagamentos();
        pagamento.setData(data);
        pagamento.setFormaPagamento(formaPagamento);
        pagamento.setHorario(h); // pode ser null
        pagamento.setValor(valor);
        pagamento.setRegistro(registro);
        pagamento.setTipoPagamento(tipoPagamento);
        pagamentosRepository.save(pagamento);
    }

    // Cadastro usando DTO
    public void cadastrarPagamentos(PagamentoDto dto){
        HorariosFuncionario h = null;
        if (dto.getHorario() != null) {
            h = horariosFuncionarioRepository.findById(dto.getHorario())
                    .orElseThrow(() -> new IllegalArgumentException("Horário não encontrado: " + dto.getHorario()));
        }

        Pagamentos pagamento = new Pagamentos();
        pagamento.setData(dto.getData());
        pagamento.setFormaPagamento(dto.getFormaPagamento());
        pagamento.setHorario(h); // pode ser null
        pagamento.setValor(dto.getValor());
        pagamento.setRegistro(dto.getRegistro());
        pagamento.setTipoPagamento(dto.getTipoPagamento());
        pagamentosRepository.save(pagamento);
    }

    // Atualização usando DTO
    public void atualizarPagamentos(PagamentoDto dto){
        if (dto.getId() == null) {
            throw new IllegalArgumentException("Id do pagamento não pode ser nulo");
        }

        Pagamentos pagamento = pagamentosRepository.findById(dto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Pagamento não encontrado: " + dto.getId()));

        HorariosFuncionario h = null;
        if (dto.getHorario() != null) {
            h = horariosFuncionarioRepository.findById(dto.getHorario())
                    .orElseThrow(() -> new IllegalArgumentException("Horário não encontrado: " + dto.getHorario()));
        }

        pagamento.setData(dto.getData());
        pagamento.setFormaPagamento(dto.getFormaPagamento());
        pagamento.setHorario(h); // pode ser null
        pagamento.setValor(dto.getValor());
        pagamento.setRegistro(dto.getRegistro());
        pagamento.setTipoPagamento(dto.getTipoPagamento());
        pagamentosRepository.save(pagamento);
    }

    // Deletar pagamento
    public void deletarPagamentos(Long id){
        if (id == null) {
            throw new IllegalArgumentException("Id do pagamento não pode ser nulo");
        }

        pagamentosRepository.findById(id)
                .ifPresent(pagamentosRepository::delete);
    }
}
