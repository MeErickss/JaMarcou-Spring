package com.example.demo.service;

import com.example.demo.dto.PagamentoDto;
import com.example.demo.model.Categorias;
import com.example.demo.model.Horarios;
import com.example.demo.model.Pagamentos;
import com.example.demo.model.enumeration.FormaPagamento;
import com.example.demo.model.enumeration.TipoPagamento;
import com.example.demo.repository.HorariosRepository;
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
    private HorariosRepository horariosRepository;

    // Listar todos
    public List<Pagamentos> listAllPagamentos() {
        return pagamentosRepository.findAll();
    }

    // Buscar por ID
    public Optional<Pagamentos> getPagamentoById(Long id) {
        return pagamentosRepository.findById(id);
    }

    public void cadastrarPagamentos(FormaPagamento formaPagamento, Long horarioId, TipoPagamento tipoPagamento, Float valor, LocalDateTime data, String registro){

        Horarios h = horariosRepository.getReferenceById(horarioId);

        Pagamentos pagamento = new Pagamentos();
        pagamento.setData(data);
        pagamento.setFormaPagamento(formaPagamento);
        pagamento.setHorario(h);
        pagamento.setValor(valor);
        pagamento.setRegistro(registro);
        pagamento.setTipoPagamento(tipoPagamento);
        pagamentosRepository.save(pagamento);
    }

    public void cadastrarPagamentos(PagamentoDto dto){

        Horarios h = horariosRepository.getReferenceById(dto.getHorario());

        Pagamentos pagamento = new Pagamentos();
        pagamento.setData(dto.getData());
        pagamento.setFormaPagamento(dto.getFormaPagamento());
        pagamento.setHorario(h);
        pagamento.setValor(dto.getValor());
        pagamento.setRegistro(dto.getRegistro());
        pagamento.setTipoPagamento(dto.getTipoPagamento());
        pagamentosRepository.save(pagamento);
    }

    public void atualizarPagamentos(PagamentoDto dto){

        Horarios h = horariosRepository.getReferenceById(dto.getHorario());

        Pagamentos pagamento = pagamentosRepository.getReferenceById(dto.getId());

        pagamento.setData(dto.getData());
        pagamento.setFormaPagamento(dto.getFormaPagamento());
        pagamento.setHorario(h);
        pagamento.setValor(dto.getValor());
        pagamento.setRegistro(dto.getRegistro());
        pagamento.setTipoPagamento(dto.getTipoPagamento());
        pagamentosRepository.save(pagamento);
    }

    public void deletarPagamentos(Long id){
        Pagamentos p = pagamentosRepository.getReferenceById(id);
        pagamentosRepository.delete(p);
    }
}
