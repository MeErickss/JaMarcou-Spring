package com.example.demo.service;

import com.example.demo.dto.ServicosDto;
import com.example.demo.model.Estabelecimentos;
import com.example.demo.model.Servicos;
import com.example.demo.model.Usuarios;
import com.example.demo.repository.EstabelecimentosRepository;
import com.example.demo.repository.ServicosRepository;
import com.example.demo.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ServicosService {

    @Autowired
    private ServicosRepository servicosRepository;

    @Autowired
    private EstabelecimentosRepository estabelecimentosRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    // Listar todos
    public List<Servicos> listAllServicos() {
        return servicosRepository.findAll();
    }

    // Buscar por ID
    public Optional<Servicos> getServicoById(Long id) {
        return servicosRepository.findById(id);
    }

    // Criar serviço sem associar usuários
    public void cadastrarServico(String descricao, String nome, Float valor,
                                 Long quantidadeDisponivel) {

        Servicos servico = new Servicos();
        servico.setDescricao(descricao);
        servico.setNome(nome);
        servico.setValor(valor);
        servico.setQuantidadeDisponivel(quantidadeDisponivel);
        servico.setUsuarios(new HashSet<>()); // inicializa lista vazia

        servicosRepository.save(servico);
    }

    public void cadastrarServico(ServicosDto dto) {

        Servicos servico = new Servicos();
        servico.setDescricao(dto.getDescricao());
        servico.setNome(dto.getNome());
        servico.setValor(dto.getValor());
        servico.setQuantidadeDisponivel(dto.getQuantidadeDisponivel());
        servico.setUsuarios(new HashSet<>()); // inicializa lista vazia

        servicosRepository.save(servico);
    }

    public void atualizarServico(ServicosDto dto) {

        Servicos servico = servicosRepository.getReferenceById(dto.getId());

        servico.setDescricao(dto.getDescricao());
        servico.setNome(dto.getNome());
        servico.setValor(dto.getValor());
        servico.setQuantidadeDisponivel(dto.getQuantidadeDisponivel());
        //servico.setUsuarios(dto.getUsuarios());
        servicosRepository.save(servico);
    }

    public void deletarServico(Long id){
        Servicos s = servicosRepository.getReferenceById(id);
        servicosRepository.delete(s);
    }

    // Associar usuários a um serviço existente
    public void associarUsuarios(Long servicoId, Long usuariosId) {
        Usuarios u = usuariosRepository.getReferenceById(usuariosId);
        Servicos s = servicosRepository.getReferenceById(servicoId);

        s.getUsuarios().add(u);

        servicosRepository.save(s);
    }

}
