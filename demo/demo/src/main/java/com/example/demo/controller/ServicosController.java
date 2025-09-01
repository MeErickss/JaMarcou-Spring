package com.example.demo.controller;

import com.example.demo.dto.PagamentoDto;
import com.example.demo.dto.ServicosDto;
import com.example.demo.model.Servicos;
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

    // 🔹 Listar todos os serviços
    @GetMapping
    public List<Servicos> listarTodos() {
        return servicosRepository.findAll();
    }

    @PostMapping
    public void cadastrarServicos(@RequestParam ServicosDto dto) {
        servicosService.cadastrarServico(dto);
    }

    @PutMapping
    public void atualizarServicos(@RequestParam ServicosDto dto){
        servicosService.atualizarServico(dto);
    }

    // 🔹 Buscar serviço por ID
    @GetMapping("/{id}")
    public ResponseEntity<Servicos> buscarPorId(@PathVariable Long id) {
        Optional<Servicos> servico = servicosRepository.findById(id);
        return servico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
