package com.example.demo.controller;

import com.example.demo.model.Estabelecimentos;
import com.example.demo.repository.EstabelecimentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estabelecimentos")
public class EstabelecimentosController {

    @Autowired
    private EstabelecimentosRepository estabelecimentosRepository;

    // 🔹 Listar todos os estabelecimentos
    @GetMapping
    public List<Estabelecimentos> listarTodos() {
        return estabelecimentosRepository.findAll();
    }

    // 🔹 Buscar estabelecimento por ID
    @GetMapping("/{id}")
    public ResponseEntity<Estabelecimentos> buscarPorId(@PathVariable Long id) {
        Optional<Estabelecimentos> estabelecimento = estabelecimentosRepository.findById(id);
        return estabelecimento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


}
