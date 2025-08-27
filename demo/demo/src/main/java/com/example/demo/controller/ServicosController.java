package com.example.demo.controller;

import com.example.demo.model.Servicos;
import com.example.demo.repository.ServicosRepository;
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

    // 🔹 Listar todos os serviços
    @GetMapping
    public List<Servicos> listarTodos() {
        return servicosRepository.findAll();
    }

    // 🔹 Buscar serviço por ID
    @GetMapping("/{id}")
    public ResponseEntity<Servicos> buscarPorId(@PathVariable Long id) {
        Optional<Servicos> servico = servicosRepository.findById(id);
        return servico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
