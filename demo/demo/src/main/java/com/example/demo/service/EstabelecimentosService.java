package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.CategoriasRepository;
import com.example.demo.repository.EstabelecimentosRepository;
import com.example.demo.repository.LocaisRepository;
import com.example.demo.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EstabelecimentosService {

    @Autowired
    private EstabelecimentosRepository estabelecimentosRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private LocaisRepository locaisRepository;

    @Autowired
    private CategoriasRepository categoriasRepository;

    // Listar todos
    public List<Estabelecimentos> listAllEstabelecimentos() {
        return estabelecimentosRepository.findAll();
    }

    // Buscar por ID
    public Optional<Estabelecimentos> getEstabelecimentoById(Long id) {
        return estabelecimentosRepository.findById(id);
    }

    public void criarEstabelecimento(Long categoriaId, Long localId, String linkImg, LocalDateTime dataCriacao, String nome, String senha) {
        Categorias c = categoriasRepository.getReferenceById(categoriaId);

        Locais l = locaisRepository.getReferenceById(localId);


        Estabelecimentos estabelecimento = new Estabelecimentos();
        estabelecimento.setCategoria(c);
        estabelecimento.setDataCriacao(dataCriacao);
        estabelecimento.setNome(nome);
        estabelecimento.setLocal(l);
        estabelecimento.setLinkImg(linkImg);
        estabelecimento.setSenha(senha);
        estabelecimentosRepository.save(estabelecimento);
    }

}
