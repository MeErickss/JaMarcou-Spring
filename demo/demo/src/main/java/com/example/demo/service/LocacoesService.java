package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocacoesService {

    @Autowired
    private LocacoesRepository locacoesRepository;

    @Autowired
    private EstabelecimentosRepository estabelecimentosRepository;

    public Locacoes createLocacao(String nome,
                                  String descricao,
                                  Float valorHora,
                                  Long estabelecimentoId) {

        Estabelecimentos e = estabelecimentosRepository.findById(estabelecimentoId)
                .orElseThrow(() -> new IllegalArgumentException("Estabelecimento não encontrado: " + estabelecimentoId));

        Locacoes l = new Locacoes();
        l.setNome(nome);
        l.setDescricao(descricao);
        l.setValorHora(valorHora);
        l.setEstabelecimento(e);

        e.getLocacoes().add(l);
        estabelecimentosRepository.save(e);

        return locacoesRepository.save(l);
    }
}
