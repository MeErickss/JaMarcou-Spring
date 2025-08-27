package com.example.demo.controller;

import com.example.demo.model.Pagamentos;
import com.example.demo.repository.PagamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentosController {

    @Autowired
    private PagamentosRepository pagamentosRepository;

    // 🔹 Listar todos os pagamentos
    @GetMapping
    public List<Pagamentos> listarTodos() {
        return pagamentosRepository.findAll();
    }

    // 🔹 Buscar pagamento por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pagamentos> buscarPorId(@PathVariable Long id) {
        Optional<Pagamentos> pagamento = pagamentosRepository.findById(id);
        return pagamento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
