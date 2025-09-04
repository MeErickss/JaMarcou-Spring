package com.example.demo.service;

import com.example.demo.model.Agendamentos;
import com.example.demo.repository.AgendamentosRepository;
import com.example.demo.repository.EstabelecimentosRepository;
import com.example.demo.repository.ServicosRepository;
import com.example.demo.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AgendamentosService {

    @Autowired
    private AgendamentosRepository agendamentosRepository;

    @Autowired
    private ServicosRepository servicosRepository;

    @Autowired
    private EstabelecimentosRepository estabelecimentosRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    // listar todos
    public List<Agendamentos> listAllAgendamentos() {
        return agendamentosRepository.findAll();
    }

    // buscar por id
    public Optional<Agendamentos> getAgendamentoById(Long id) {
        return agendamentosRepository.findById(id);
    }

    // deletar
    public void deletarAgendamento(Long id) {
        Agendamentos a = agendamentosRepository.getReferenceById(id);
        agendamentosRepository.delete(a);
    }
}
