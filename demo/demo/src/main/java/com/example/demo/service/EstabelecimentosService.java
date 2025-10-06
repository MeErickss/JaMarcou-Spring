package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.HashSet;

@Service
public class EstabelecimentosService {

    @Autowired
    private EstabelecimentosRepository estabelecimentosRepository;

    @Autowired
    private LocaisRepository locaisRepository;

    @Autowired
    private CategoriasRepository categoriasRepository;

    /**
     * Cria um estabelecimento com parâmetros diretos (sem DTO).
     * Categoria e Local são referenciados por ID.
     */
    public Estabelecimentos createEstabelecimento(Long categoriaId,
                                                  Long localId,
                                                  String nome,
                                                  String cnpj,
                                                  OffsetDateTime dataCriacao,
                                                  String senha,
                                                  String telefone,
                                                  String linkImg,
                                                  String descricao) {

        Categorias c = categoriasRepository.findById(categoriaId)
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada: " + categoriaId));
        Locais l = locaisRepository.findById(localId)
                .orElseThrow(() -> new IllegalArgumentException("Local não encontrado: " + localId));

        Estabelecimentos e = new Estabelecimentos();
        e.setCategoria(c);
        e.setLocal(l);
        e.setNome(nome);
        e.setCnpj(cnpj);
        e.setDataCriacao(dataCriacao != null ? dataCriacao : OffsetDateTime.now());
        e.setSenha(senha);
        e.setTelefone(telefone);
        e.setLinkImg(linkImg);
        e.setDescricao(descricao);
        e.setGerentes(new HashSet<>());
        e.setFuncionarios(new HashSet<>());
        e.setServicos(new HashSet<>());
        e.setLocacoes(new HashSet<>());

        return estabelecimentosRepository.save(e);
    }
}
