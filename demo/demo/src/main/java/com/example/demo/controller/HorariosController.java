package com.example.demo.controller;

import com.example.demo.model.Horarios;
import com.example.demo.repository.HorariosRepository;
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

    // 🔹 Listar todos os horários
    @GetMapping
    public List<Horarios> listarTodos() {
        return horariosRepository.findAll();
    }

    // 🔹 Buscar horário por ID
    @GetMapping("/{id}")
    public ResponseEntity<Horarios> buscarPorId(@PathVariable Long id) {
        Optional<Horarios> horario = horariosRepository.findById(id);
        return horario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
