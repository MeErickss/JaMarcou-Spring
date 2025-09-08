package com.example.demo.service;

import com.example.demo.dto.EstabelecimentosDto;
import com.example.demo.model.*;
import com.example.demo.model.enumeration.Funcoes;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class EstabelecimentosService {

    @Autowired
    private EstabelecimentosRepository estabelecimentosRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private LocaisRepository locaisRepository;

    @Autowired
    private ServicosRepository servicosRepository;

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

    public void cadastrarEstabelecimento(Long categoriaId, Long localId, String linkImg, LocalDateTime dataCriacao, String nome, String senha, String telefone, String descricao) {
        Categorias c = categoriasRepository.getReferenceById(categoriaId);

        Locais l = locaisRepository.getReferenceById(localId);


        Estabelecimentos e = new Estabelecimentos();
        e.setCategoria(c);
        e.setDataCriacao(dataCriacao);
        e.setNome(nome);
        e.setLocal(l);
        e.setLinkImg(linkImg);
        e.setSenha(senha);
        e.setTelefone(telefone);
        e.setUsuarios(new HashSet<>());
        e.setServicos(new HashSet<>());
        e.setDescricao(descricao);
        estabelecimentosRepository.save(e);
    }

    public void cadastrarEstabelecimento(EstabelecimentosDto dto) {
        Categorias c = categoriasRepository.getReferenceById(dto.getCategoriaId());

        Locais l = locaisRepository.getReferenceById(dto.getLocalId());


        Estabelecimentos e = new Estabelecimentos();
        e.setCategoria(c);
        e.setDataCriacao(dto.getDataCriacao());
        e.setNome(dto.getNome());
        e.setLocal(l);
        e.setLinkImg(dto.getLinkImg());
        e.setTelefone(dto.getTelefone());
        e.setSenha(dto.getSenha());
        e.setUsuarios(new HashSet<>());
        e.setServicos(new HashSet<>());
        e.setDescricao(dto.getDescricao());
        estabelecimentosRepository.save(e);
    }

    public void atualizarEstabelecimento(EstabelecimentosDto dto) {
        Estabelecimentos e = estabelecimentosRepository.getReferenceById(dto.getId());

        Categorias c = categoriasRepository.getReferenceById(dto.getCategoriaId());

        Locais l = locaisRepository.getReferenceById(dto.getLocalId());


        e.setCategoria(c);
        e.setDataCriacao(dto.getDataCriacao());
        e.setNome(dto.getNome());
        e.setLocal(l);
        e.setLinkImg(dto.getLinkImg());
        e.setTelefone(dto.getTelefone());
        e.setSenha(dto.getSenha());
        e.setUsuarios(new HashSet<>());
        e.setServicos(new HashSet<>());
        estabelecimentosRepository.save(e);
    }

    public void deleteEstabelecimento(Long id){
        Estabelecimentos e = estabelecimentosRepository.getReferenceById(id);
        estabelecimentosRepository.delete(e);
    }


    public void associarUsuario(Long usuarioId, Long estabelecimentoId) {
        Usuarios u = usuariosRepository.getReferenceById(usuarioId);
        Estabelecimentos e = estabelecimentosRepository.getReferenceById(estabelecimentoId);

        boolean jaTemGerente = e.getUsuarios().stream()
                .anyMatch(user -> user.getFuncoes().contains(Funcoes.GERENTE));

        // Cria uma nova lista mutável contendo CLIENTE sempre
        Set<Funcoes> novasFuncoes = new HashSet<>();
        novasFuncoes.add(Funcoes.CLIENTE);

        if (!jaTemGerente) {
            // [CLIENTE, FUNCIONARIO, GERENTE]
            novasFuncoes.add(Funcoes.FUNCIONARIO);
            novasFuncoes.add(Funcoes.GERENTE);
        } else {
            // [CLIENTE, FUNCIONARIO]
            novasFuncoes.add(Funcoes.FUNCIONARIO);
        }

        // Substitui a lista (não tenta mutar a original)
        u.setFuncoes(novasFuncoes);

        // Associa o usuário ao estabelecimento (evita duplicata)
        if (!e.getUsuarios().contains(u)) {
            e.getUsuarios().add(u);
        }

        estabelecimentosRepository.save(e);
    }


    public void associarServicos(Long servicoId, Long estabelecimentoId){
        Servicos s = servicosRepository.getReferenceById(servicoId);
        Estabelecimentos e = estabelecimentosRepository.getReferenceById(estabelecimentoId);

        e.getServicos().add(s);
        estabelecimentosRepository.save(e);
    }

}
