package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.model.enumeration.StatusHorario;
import com.example.demo.repository.EstabelecimentosRepository;
import com.example.demo.repository.HorariosRepository;
import com.example.demo.repository.PagamentosRepository;
import com.example.demo.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class HorariosService {

    @Autowired
    private HorariosRepository horariosRepository;

    @Autowired
    private EstabelecimentosRepository estabelecimentosRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private PagamentosRepository pagamentosRepository;

    // Listar todos
    public List<Horarios> listAllHorarios() {
        return horariosRepository.findAll();
    }

    // Buscar por ID
    public Optional<Horarios> getHorarioById(Long id) {
        return horariosRepository.findById(id);
    }

    public void criarHorario(StatusHorario statusHorario, LocalDateTime dataInicio, LocalDateTime dataFim, LocalDateTime dataMarcacao, Long estabelecimentoId, Long usuarioId){

        Estabelecimentos e = estabelecimentosRepository.getReferenceById(estabelecimentoId);

        Usuarios u = usuariosRepository.getReferenceById(usuarioId);

        Horarios horario = new Horarios();
        horario.setStatusHorario(statusHorario);
        horario.setDataFim(dataFim);
        horario.setUsuario(u);
        horario.setDataMarcacao(dataMarcacao);
        horario.setDataInicio(dataInicio);
        horario.setEstabelecimento(e);
        horariosRepository.save(horario);

    }
}
