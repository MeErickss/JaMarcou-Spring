package com.example.demo.service;

import com.example.demo.dto.AgendamentosDto;
import com.example.demo.model.*;
import com.example.demo.model.enumeration.StatusHorario;
import com.example.demo.repository.*;
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
    private HorariosRepository horariosRepository;

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


    public void criarAgendamento(Long servicoId, Long estabelecimentoId, Long clienteId, Long funcionarioId, Long horarioId, LocalDateTime criadoEm, StatusHorario statusHorario, String observacoes){
        Servicos s = servicosRepository.getReferenceById(servicoId);
        Estabelecimentos e = estabelecimentosRepository.getReferenceById(estabelecimentoId);
        Usuarios c = usuariosRepository.getReferenceById(clienteId);
        Usuarios f = usuariosRepository.getReferenceById(funcionarioId);
        Horarios h = horariosRepository.getReferenceById(horarioId);

        Agendamentos a = new Agendamentos();

        a.setCliente(c);
        a.setStatus(statusHorario);
        a.setEstabelecimento(e);
        a.setCriadoEm(criadoEm);
        a.setObservacoes(observacoes);
        a.setServico(s);
        a.setHorario(h);
        a.setFuncionario(f);

        agendamentosRepository.save(a);
    }

    public void criarAgendamento(AgendamentosDto dto){
        Servicos s = servicosRepository.getReferenceById(dto.getServicoId());
        Estabelecimentos e = estabelecimentosRepository.getReferenceById(dto.getEstabelecimentoId());
        Usuarios c = usuariosRepository.getReferenceById(dto.getClienteId());
        Usuarios f = usuariosRepository.getReferenceById(dto.getFuncionarioId());
        Horarios h = horariosRepository.getReferenceById(dto.getHorarioId());

        Agendamentos a = new Agendamentos();

        a.setCliente(c);
        a.setStatus(dto.getStatus());
        a.setEstabelecimento(e);
        a.setCriadoEm(LocalDateTime.now());
        a.setObservacoes(dto.getObservacoes());
        a.setServico(s);
        a.setHorario(h);
        a.setFuncionario(f);

        agendamentosRepository.save(a);
    }


    // deletar
    public void deletarAgendamento(Long id) {
        Agendamentos a = agendamentosRepository.getReferenceById(id);
        agendamentosRepository.delete(a);
    }
}
