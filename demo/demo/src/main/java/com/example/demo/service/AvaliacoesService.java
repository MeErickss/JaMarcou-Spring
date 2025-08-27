package com.example.demo.service;

import com.example.demo.model.Avaliacoes;
import com.example.demo.model.Estabelecimentos;
import com.example.demo.model.Horarios;
import com.example.demo.repository.AvaliacoesRepository;
import com.example.demo.repository.EstabelecimentosRepository;
import com.example.demo.repository.HorariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliacoesService {

    @Autowired
    private AvaliacoesRepository avaliacoesRepository;

    @Autowired
    private HorariosRepository horariosRepository;

    @Autowired
    private EstabelecimentosRepository estabelecimentosRepository;

    // Listar todas
    public List<Avaliacoes> listAllAvaliacoes() {
        return avaliacoesRepository.findAll();
    }

    // Buscar por ID
    public Optional<Avaliacoes> getAvaliacaoById(Long id) {
        return avaliacoesRepository.findById(id);
    }

    public void criarAvaliacao(Float nota, Long estabelecimentoId, Long horarioId){

        Horarios h = horariosRepository.getReferenceById(horarioId);

        Estabelecimentos e = estabelecimentosRepository.getReferenceById(horarioId);

        Avaliacoes avaliacao = new Avaliacoes();
        avaliacao.setEstabelecimento(e);
        avaliacao.setNota(nota);
        avaliacao.setHorario(h);
        avaliacoesRepository.save(avaliacao);
    }
}
