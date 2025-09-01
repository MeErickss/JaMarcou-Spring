package com.example.demo.controller;

import com.example.demo.dto.AvaliacoesDto;
import com.example.demo.model.Avaliacoes;
import com.example.demo.service.AvaliacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/avaliacoes")
public class AvaliacoesController {

    @Autowired
    private AvaliacoesService avaliacoesService;


    // Listar todas as avaliações
    @GetMapping
    public ResponseEntity<List<Avaliacoes>> getAllAvaliacoes() {
        List<Avaliacoes> avaliacoes = avaliacoesService.listAllAvaliacoes();
        return ResponseEntity.ok(avaliacoes);
    }

    @PostMapping
    public void cadastrarAvaliacoes(@RequestParam AvaliacoesDto dto) {
        avaliacoesService.cadastrarAvaliacao(dto);
    }

    @PutMapping
    public void atualizarAvaliacoes(@RequestParam AvaliacoesDto dto){
        avaliacoesService.atualizarAvaliacao(dto);
    }

    // Buscar avaliação por ID
    @GetMapping("/{id}")
    public ResponseEntity<Avaliacoes> getAvaliacaoById(@PathVariable Long id) {
        Optional<Avaliacoes> avaliacao = avaliacoesService.getAvaliacaoById(id);
        return avaliacao.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
