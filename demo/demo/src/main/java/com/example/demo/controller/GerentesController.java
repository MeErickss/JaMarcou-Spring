package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.repository.EstabelecimentosRepository;
import com.example.demo.repository.FuncionariosRepository;
import com.example.demo.repository.GerentesRepository;
import com.example.demo.service.FuncionariosService;
import com.example.demo.service.GerentesService;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/gerentes")
public class GerentesController {

    @Autowired
    private GerentesService gerentesService;

    @Autowired
    private GerentesRepository gerentesRepository;

    @Autowired
    private EstabelecimentosRepository estabelecimentosRepository;

    // 🔹 Listar todos os estabelecimentos
    @GetMapping
    public List<Gerentes> listarGerentes() {
        return gerentesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Gerentes>> getGerentesById(@PathVariable Long id) {
        Optional<Gerentes> gerentes = gerentesRepository.findById(id);
        return ResponseEntity.ok(gerentes);
    }

    @GetMapping("/{id}/raw")
    public ResponseEntity<Gerentes> getGerentesRaw(@PathVariable Long id) {
        Optional<Gerentes> gerentesOpt = gerentesRepository.findBasicById(id);

        if (gerentesOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(gerentesOpt.get());
    }

    // GET /api/estabelecimentos/{id}/servicos
    @GetMapping("/{id}/contrato")
    public ResponseEntity<Object[]> getContrato(@PathVariable Long id) {
        Optional<Object[]> gerentes = gerentesRepository.findContractDatesById(id);

        if (gerentes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(gerentes.get());
    }

    // GET /api/estabelecimentos/{id}/servicos
    @GetMapping("/{id}/estabelecimento")
    public ResponseEntity<Estabelecimentos> getEstabelecimento(@PathVariable Long id) {
        if (!gerentesRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Gerentes gerentes = gerentesRepository.findById(id).orElse(null);

        Estabelecimentos estabelecimentos = estabelecimentosRepository.findByGerentes(gerentes);
        return ResponseEntity.ok(estabelecimentos);
    }
}
