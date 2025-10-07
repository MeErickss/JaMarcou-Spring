package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.repository.EstabelecimentosRepository;
import com.example.demo.repository.FuncionariosRepository;
import com.example.demo.repository.HorariosFuncionarioRepository;
import com.example.demo.service.EstabelecimentosService;
import com.example.demo.service.FuncionariosService;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionariosController {

    @Autowired
    private FuncionariosService funcionariosService;

    @Autowired
    private FuncionariosRepository funcionariosRepository;

    @Autowired
    private EstabelecimentosRepository estabelecimentosRepository;

    @Autowired
    private HorariosFuncionarioRepository horariosFuncionarioRepository;


    // 🔹 Listar todos os estabelecimentos
    @GetMapping
    public List<Funcionarios> listarFuncionarios() {
        return funcionariosRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Funcionarios>> getFuncionariosById(@PathVariable Long id) {
        Optional<Funcionarios> funcionarios = funcionariosRepository.findById(id);
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/{id}/raw")
    public ResponseEntity<Funcionarios> getFuncionariosRaw(@PathVariable Long id) {
        Optional<Funcionarios> funcionariosOpt = funcionariosRepository.findBasicById(id);

        if (funcionariosOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(funcionariosOpt.get());
    }

    // GET /api/estabelecimentos/{id}/servicos
    @GetMapping("/{id}/contrato")
    public ResponseEntity<Object[]> getContrato(@PathVariable Long id) {
        Optional<Object[]> funcionariosOpt = funcionariosRepository.findContractDatesById(id);

        if (funcionariosOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(funcionariosOpt.get());
    }

    // GET /api/estabelecimentos/{id}/servicos
    @GetMapping("/{id}/estabelecimento")
    public ResponseEntity<Estabelecimentos> getEstabelecimento(@PathVariable Long id) {
        if (!funcionariosRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Funcionarios funcionarios = funcionariosRepository.findById(id).orElse(null);

        Estabelecimentos estabelecimentos = estabelecimentosRepository.findByFuncionarios(funcionarios);
        return ResponseEntity.ok(estabelecimentos);
    }

    // GET /api/estabelecimentos/{id}/servicos
    @GetMapping("/{id}/horarios")
    public ResponseEntity<List<HorariosFuncionario>> getHorarios(@PathVariable Long id) {
        if (!funcionariosRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Funcionarios funcionarios = funcionariosRepository.findById(id).orElse(null);

        List<HorariosFuncionario> horariosFuncionario = horariosFuncionarioRepository.findByFuncionario(funcionarios);
        return ResponseEntity.ok(horariosFuncionario);
    }
}
