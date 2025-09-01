package com.example.demo.controller;

import com.example.demo.dto.EstabelecimentosDto;
import com.example.demo.dto.HorariosDto;
import com.example.demo.model.Horarios;
import com.example.demo.repository.HorariosRepository;
import com.example.demo.service.HorariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public void atualizarHorarios(@RequestParam HorariosDto dto){
        horariosService.atualizarHorario(dto);
    }

    // 🔹 Buscar horário por ID
    @GetMapping("/{id}")
    public ResponseEntity<Horarios> buscarPorId(@PathVariable Long id) {
        Optional<Horarios> horario = horariosRepository.findById(id);
        return horario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
