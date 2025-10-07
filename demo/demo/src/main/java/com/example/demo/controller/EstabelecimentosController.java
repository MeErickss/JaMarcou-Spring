package com.example.demo.controller;

import com.example.demo.dto.CadastroDto;
import com.example.demo.dto.EstabelecimentosDto;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.EstabelecimentosService;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/estabelecimentos")
public class EstabelecimentosController {

    @Autowired
    private EstabelecimentosRepository estabelecimentosRepository;

    @Autowired
    private EstabelecimentosService estabelecimentosService;

    @Autowired
    private LocacoesRepository locacoesRepository;

    @Autowired
    private ServicosRepository servicosRepository;

    @Autowired
    private FuncionariosRepository funcionariosRepository;

    @Autowired
    private GerentesRepository gerentesRepository;

    // 🔹 Listar todos os estabelecimentos
    @GetMapping
    public List<Estabelecimentos> listarEstabelecimentos() {
        return estabelecimentosRepository.findAll();
    }

    @GetMapping("/{id}/raw")
    public ResponseEntity<Estabelecimentos> getEstabelecimentosRaw(@PathVariable Long id) {
        Optional<Estabelecimentos> estabelecimentosOpt = estabelecimentosRepository.findBasicById(id);

        if (estabelecimentosOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(estabelecimentosOpt.get());
    }

    // GET /api/estabelecimentos/{id}/gerentes
    @GetMapping("/{id}/gerentes")
    public ResponseEntity<List<Gerentes>> getGerentes(@PathVariable Long id) {
        // verifica se estabelecimento existe (opcional)
        if (!estabelecimentosRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Estabelecimentos estabelecimentos = estabelecimentosRepository.findById(id).orElse(null);

        List<Gerentes> gerentes = gerentesRepository.findByEstabelecimento(estabelecimentos);
        return ResponseEntity.ok(gerentes);
    }

    // GET /api/estabelecimentos/{id}/funcionarios
    @GetMapping("/{id}/funcionarios")
    public ResponseEntity<List<Funcionarios>> getFuncionarios(@PathVariable Long id) {
        if (!estabelecimentosRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Estabelecimentos estabelecimentos = estabelecimentosRepository.findById(id).orElse(null);

        List<Funcionarios> funcionarios = funcionariosRepository.findByEstabelecimento(estabelecimentos);
        return ResponseEntity.ok(funcionarios);
    }

    // GET /api/estabelecimentos/{id}/servicos
    @GetMapping("/{id}/servicos")
    public ResponseEntity<List<Servicos>> getServicos(@PathVariable Long id) {
        if (!estabelecimentosRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Estabelecimentos estabelecimentos = estabelecimentosRepository.findById(id).orElse(null);

        List<Servicos> servicos = servicosRepository.findByEstabelecimento(estabelecimentos);
        return ResponseEntity.ok(servicos);
    }

    // GET /api/estabelecimentos/{id}/locacoes
    @GetMapping("/{id}/locacoes")
    public ResponseEntity<List<Locacoes>> getLocacoes(@PathVariable Long id) {
        if (!estabelecimentosRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Estabelecimentos estabelecimentos = estabelecimentosRepository.findById(id).orElse(null);

        List<Locacoes> locacoes = locacoesRepository.findByEstabelecimento(estabelecimentos);
        return ResponseEntity.ok(locacoes);
    }
}
