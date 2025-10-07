package com.example.demo.controller;

import com.example.demo.dto.HorariosFuncionarioDto;
import com.example.demo.model.*;
import com.example.demo.model.enumeration.StatusHorario;
import com.example.demo.repository.FuncionariosRepository;
import com.example.demo.repository.HorariosFuncionarioRepository;
import com.example.demo.service.HorariosFuncionarioService;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/horariosfuncionarios")
public class HorariosFuncionarioController {

    @Autowired
    private HorariosFuncionarioRepository horariosFuncionarioRepository;

    @Autowired
    private HorariosFuncionarioService horariosFuncionarioService;

    @Autowired
    private FuncionariosRepository funcionariosRepository;

    // 🔹 Listar todos os horários
    @GetMapping
    public List<HorariosFuncionario> listarHorariosFuncionario() {
        return horariosFuncionarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<HorariosFuncionario>> getHorariosFuncionarioById(@PathVariable Long id) {
        Optional<HorariosFuncionario> horariosFuncionario = horariosFuncionarioRepository.findById(id);
        return ResponseEntity.ok(horariosFuncionario);
    }

    @GetMapping("/{id}/raw")
    public ResponseEntity<HorariosFuncionario> getHorariosFuncionarioRaw(@PathVariable Long id) {
        Optional<HorariosFuncionario> horariosFuncionarioOpt = horariosFuncionarioRepository.findBasicById(id);

        if (horariosFuncionarioOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(horariosFuncionarioOpt.get());
    }

    // GET /api/estabelecimentos/{id}/servicos
    @GetMapping("/{id}/funcionario")
    public ResponseEntity<List<Funcionarios>> getFuncionario(@PathVariable Long id) {
        if (!horariosFuncionarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        HorariosFuncionario horariosFuncionario = horariosFuncionarioRepository.findById(id).orElse(null);

        List<Funcionarios> funcionario = funcionariosRepository.findByHorariosFuncionario(horariosFuncionario);
        return ResponseEntity.ok(funcionario);
    }
}
