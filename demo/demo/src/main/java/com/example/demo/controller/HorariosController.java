package com.example.demo.controller;

import com.example.demo.dto.EstabelecimentosDto;
import com.example.demo.dto.HorariosDto;
import com.example.demo.model.Horarios;
import com.example.demo.model.enumeration.StatusHorario;
import com.example.demo.repository.HorariosRepository;
import com.example.demo.service.HorariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/horarios")
public class HorariosController {

    @Autowired
    private HorariosRepository horariosRepository;

    @Autowired
    private HorariosService horariosService;

    // 🔹 Listar todos os horários
    @GetMapping
    public List<Horarios> listarTodos() {
        return horariosRepository.findAll();
    }

    @PostMapping
    public void cadastrarHorarios(@RequestParam HorariosDto dto) {
        horariosService.cadastrarHorario(dto);
    }

    @PutMapping
    public void atualizarHorarios(@RequestBody HorariosDto dto){
        horariosService.atualizarHorario(dto);
    }

    @PutMapping("/status/{id:\\d+}")
    public Horarios atualizarStatusHorarios(@PathVariable Long id, @RequestBody StatusHorario statusHorario){
        return horariosService.atualizarStatusHorario(id, statusHorario);
    }

    // 🔹 Buscar horário por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Object[] horario = horariosRepository.findMinStartAndMaxEndByEstabelecimentoId(id);
        return ResponseEntity.ok(horario);
    }

    @GetMapping("/estabelecimento/{usuarioId}")
    public List<Horarios> listarTodosEstabelecimento(@PathVariable Long usuarioId) {
        return horariosRepository.findHorariosByEstabelecimentoOfUsuario(usuarioId);
    }

    @DeleteMapping
    public void deletarHorarios(@RequestParam HorariosDto dto){
        horariosService.deletarHorario(dto.getId());
    }
}
