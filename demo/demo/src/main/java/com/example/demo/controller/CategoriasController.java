package com.example.demo.controller;

import com.example.demo.dto.AvaliacoesDto;
import com.example.demo.dto.CategoriasDto;
import com.example.demo.model.Categorias;
import com.example.demo.repository.CategoriasRepository;
import com.example.demo.service.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorias")
public class CategoriasController {

    @Autowired
    private CategoriasRepository categoriasRepository;

    @Autowired
    private CategoriasService categoriasService;

    // 🔹 Listar todas as categorias
    @GetMapping
    public List<Categorias> listarCategorias() {
        return categoriasRepository.findAll();
    }

    @PostMapping
    public void cadastrarCategorias(@RequestParam CategoriasDto dto) {
        categoriasService.cadastrarCategoria(dto);
    }

    @PutMapping
    public void atualizarCategorias(@RequestParam CategoriasDto dto){
        categoriasService.atualizarCategoria(dto);
    }

    // 🔹 Buscar categoria por ID
    @GetMapping("/{id}")
    public ResponseEntity<Categorias> buscarCategoria(@PathVariable Long id) {
        Optional<Categorias> categoria = categoriasRepository.findById(id);
        return categoria.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
