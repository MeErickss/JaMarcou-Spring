package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.repository.EstabelecimentosRepository;
import com.example.demo.repository.FuncionariosRepository;
import com.example.demo.repository.ServicosRepository;
import com.example.demo.service.ServicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicos")
public class ServicosController {

    @Autowired
    private ServicosRepository servicosRepository;

    @Autowired
    private ServicosService servicosService;

    @Autowired
    private EstabelecimentosRepository estabelecimentosRepository;

    @Autowired
    private FuncionariosRepository funcionariosRepository;

    // 🔹 Listar todos os serviços
    @GetMapping
    public List<Servicos> listarServicos() {
        return servicosRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Servicos>> getServicosById(@PathVariable Long id) {
        Optional<Servicos> servicos = servicosRepository.findById(id);
        return ResponseEntity.ok(servicos);
    }

    @GetMapping("/{id}/raw")
    public ResponseEntity<Servicos> getServicosRaw(@PathVariable Long id) {
        Optional<Servicos> servicosOpt = servicosRepository.findBasicById(id);

        if (servicosOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(servicosOpt.get());
    }

    // GET /api/estabelecimentos/{id}/servicos
    @GetMapping("/{id}/estabelecimento")
    public ResponseEntity<Estabelecimentos> getEstabelecimentos(@PathVariable Long id) {
        if (!servicosRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Servicos servicos = servicosRepository.findById(id).orElse(null);

        Estabelecimentos estabelecimentos = estabelecimentosRepository.findByServicos(servicos);
        return ResponseEntity.ok(estabelecimentos);
    }

    // GET /api/estabelecimentos/{id}/servicos
    @GetMapping("/{id}/funcionarios")
    public ResponseEntity<List<Funcionarios>> getFuncionarios(@PathVariable Long id) {
        if (!servicosRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        List<Funcionarios> funcionarios = funcionariosRepository.findFuncionariosByServicosId(id);
        return ResponseEntity.ok(funcionarios);
    }
}
