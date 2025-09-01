package com.example.demo.service;

import com.example.demo.dto.EstabelecimentosDto;
import com.example.demo.model.*;
import com.example.demo.model.enumeration.Funcoes;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
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

    public void cadastrarEstabelecimento(Long categoriaId, Long localId, String linkImg, LocalDateTime dataCriacao, String nome, String senha, String telefone) {
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

        if (!jaTemGerente) {
            u.getFuncoes().clear();
            u.getFuncoes().add(Funcoes.GERENTE);
        } else {
            u.getFuncoes().clear();
            u.getFuncoes().add(Funcoes.FUNCIONARIO);
        }

        // Associa o usuário ao estabelecimento
        e.getUsuarios().add(u);
        estabelecimentosRepository.save(e);
    }


    public void associarServicos(Long servicoId, Long estabelecimentoId){
        Servicos s = servicosRepository.getReferenceById(servicoId);
        Estabelecimentos e = estabelecimentosRepository.getReferenceById(estabelecimentoId);

        e.getServicos().add(s);
        estabelecimentosRepository.save(e);
    }

}
