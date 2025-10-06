package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class ServicosService {

    @Autowired
    private ServicosRepository servicosRepository;

    @Autowired
    private EstabelecimentosRepository estabelecimentosRepository;

    @Autowired
    private FuncionariosRepository funcionariosRepository;

    /**
     * Cria um serviço vinculado a um estabelecimento e a um funcionário (prestador).
     */
    public Servicos createServico(String nome,
                                  String descricao,
                                  Float valor,
                                  Long quantidadeDisponivel,
                                  Long estabelecimentoId,
                                  Long prestadorId) {

        Estabelecimentos e = estabelecimentosRepository.findById(estabelecimentoId)
                .orElseThrow(() -> new IllegalArgumentException("Estabelecimento não encontrado: " + estabelecimentoId));
        Funcionarios prestador = funcionariosRepository.findById(prestadorId)
                .orElseThrow(() -> new IllegalArgumentException("Prestador (funcionário) não encontrado: " + prestadorId));

        Servicos s = new Servicos();
        s.setNome(nome);
        s.setDescricao(descricao);
        s.setValor(valor);
        s.setQuantidadeDisponivel(quantidadeDisponivel);
        s.setEstabelecimento(e);
        s.setPrestador(prestador);

        // opcional: adicionar ao conjunto do estabelecimento (bidirecional)
        e.getServicos().add(s);
        estabelecimentosRepository.save(e); // salva vínculo

        return servicosRepository.save(s);
    }
}
