package com.example.demo.controller;

import com.example.demo.model.Locais;
import com.example.demo.repository.LocaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/locais")
public class LocaisController {

    @Autowired
    private LocaisRepository locaisRepository;

    // 🔹 Listar todos os locais
    @GetMapping
    public List<Locais> listarTodos() {
        return locaisRepository.findAll();
    }

    // 🔹 Buscar local por ID
    @GetMapping("/{id}")
    public ResponseEntity<Locais> buscarPorId(@PathVariable Long id) {
        Optional<Locais> local = locaisRepository.findById(id);
        return local.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
