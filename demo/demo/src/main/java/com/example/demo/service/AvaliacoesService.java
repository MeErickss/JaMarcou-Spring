package com.example.demo.service;

import com.example.demo.dto.AvaliacoesDto;
import com.example.demo.model.Avaliacoes;
import com.example.demo.model.Estabelecimentos;
import com.example.demo.model.HorariosFuncionario;
import com.example.demo.repository.AvaliacoesRepository;
import com.example.demo.repository.EstabelecimentosRepository;
import com.example.demo.repository.HorariosFuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliacoesService {

    @Autowired
    private AvaliacoesRepository avaliacoesRepository;

    @Autowired
    private HorariosFuncionarioRepository horariosFuncionarioRepository;

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

    public void cadastrarAvaliacao(Float nota, Long estabelecimentoId, Long horarioId){

        HorariosFuncionario h = horariosFuncionarioRepository.getReferenceById(horarioId);

        Estabelecimentos e = estabelecimentosRepository.getReferenceById(estabelecimentoId);

        Avaliacoes avaliacao = new Avaliacoes();
        avaliacao.setEstabelecimento(e);
        avaliacao.setNota(nota);
        avaliacao.setHorario(h);
        avaliacoesRepository.save(avaliacao);
    }

    public void cadastrarAvaliacao(AvaliacoesDto dto){

        HorariosFuncionario h = horariosFuncionarioRepository.getReferenceById(dto.getHorarioId());

        Estabelecimentos e = estabelecimentosRepository.getReferenceById(dto.getEstabelecimentoId());

        Avaliacoes avaliacao = new Avaliacoes();
        avaliacao.setEstabelecimento(e);
        avaliacao.setNota(dto.getNota());
        avaliacao.setHorario(h);
        avaliacoesRepository.save(avaliacao);
    }

    public void atualizarAvaliacao(AvaliacoesDto dto){

        Avaliacoes a = avaliacoesRepository.getReferenceById(dto.getId());

        HorariosFuncionario h = horariosFuncionarioRepository.getReferenceById(dto.getHorarioId());

        Estabelecimentos e = estabelecimentosRepository.getReferenceById(dto.getEstabelecimentoId());

        a.setEstabelecimento(e);
        a.setNota(dto.getNota());
        a.setHorario(h);
        avaliacoesRepository.save(a);
    }

    public void deletarAvaliacao(Long id){
        Avaliacoes a = avaliacoesRepository.getReferenceById(id);
        avaliacoesRepository.delete(a);
    }
}
