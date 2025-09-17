package com.example.demo.service;

import com.example.demo.dto.HorariosDto;
import com.example.demo.model.*;
import com.example.demo.model.enumeration.DiasSemana;
import com.example.demo.model.enumeration.StatusHorario;
import com.example.demo.repository.EstabelecimentosRepository;
import com.example.demo.repository.HorariosRepository;
import com.example.demo.repository.PagamentosRepository;
import com.example.demo.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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

    public void cadastrarHorario(StatusHorario statusHorario, Timestamp dataInicio, Timestamp dataFim, LocalDateTime dataMarcacao, Long estabelecimentoId, Long usuarioId, DiasSemana diaSemana){

        Estabelecimentos e = estabelecimentosRepository.getReferenceById(estabelecimentoId);

        Usuarios u = usuariosRepository.getReferenceById(usuarioId);

        Horarios h = new Horarios();
        h.setStatusHorario(statusHorario);
        h.setDataFim(dataFim);
        h.setUsuario(u);
        h.setDataMarcacao(dataMarcacao);
        h.setDataInicio(dataInicio);
        h.setEstabelecimento(e);
        h.setDiaSemana(diaSemana);
        horariosRepository.save(h);

    }

    public void cadastrarHorario(HorariosDto dto){

        Estabelecimentos e = estabelecimentosRepository.getReferenceById(dto.getEstabelecimentoId());

        Usuarios u = usuariosRepository.getReferenceById(dto.getUsuarioId());

        Horarios h = new Horarios();
        h.setStatusHorario(dto.getStatusHorario());
        h.setDataFim(dto.getDataFim());
        h.setUsuario(u);
        h.setDataMarcacao(dto.getDataMarcacao());
        h.setDataInicio(dto.getDataInicio());
        h.setEstabelecimento(e);
        h.setDiaSemana(dto.getDiaSemana());
        horariosRepository.save(h);

    }

    public void atualizarHorario(HorariosDto dto){

        Horarios h = horariosRepository.getReferenceById(dto.getId());

        Estabelecimentos e = estabelecimentosRepository.getReferenceById(dto.getEstabelecimentoId());

        Usuarios u = usuariosRepository.getReferenceById(dto.getUsuarioId());

        h.setStatusHorario(dto.getStatusHorario());
        h.setDataFim(dto.getDataFim());
        h.setUsuario(u);
        h.setDataMarcacao(dto.getDataMarcacao());
        h.setDataInicio(dto.getDataInicio());
        h.setEstabelecimento(e);
        h.setDiaSemana(dto.getDiaSemana());
        horariosRepository.save(h);
    }

    public void deletarHorario(Long id){
        Horarios h = horariosRepository.getReferenceById(id);
        horariosRepository.delete(h);
    }
}
