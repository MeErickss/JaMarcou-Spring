package com.example.demo.service;

import com.example.demo.model.Estabelecimentos;
import com.example.demo.model.Servicos;
import com.example.demo.model.Usuarios;
import com.example.demo.repository.EstabelecimentosRepository;
import com.example.demo.repository.ServicosRepository;
import com.example.demo.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Servicos criarServico(String descricao, String nome, Float valor, Long estabelecimentoId,
                                 Long quantidadeDisponivel) {

        Estabelecimentos e = estabelecimentosRepository.getReferenceById(estabelecimentoId);

        Servicos servico = new Servicos();
        servico.setDescricao(descricao);
        servico.setNome(nome);
        servico.setEstabelecimento(e);
        servico.setValor(valor);
        servico.setQuantidadeDisponivel(quantidadeDisponivel);
        servico.setUsuarios(new ArrayList<>()); // inicializa lista vazia

        return servicosRepository.save(servico);
    }

    // Associar usuários a um serviço existente
    public void associarUsuarios(Long servicoId, Long usuariosId) {
        Usuarios u = usuariosRepository.getReferenceById(usuariosId);
        Servicos s = servicosRepository.getReferenceById(servicoId);

        s.getUsuarios().add(u);

        servicosRepository.save(s);
    }

}
