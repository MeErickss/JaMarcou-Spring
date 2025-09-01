package com.example.demo.controller;

import com.example.demo.dto.LocaisDto;
import com.example.demo.dto.PagamentoDto;
import com.example.demo.model.Pagamentos;
import com.example.demo.repository.PagamentosRepository;
import com.example.demo.service.PagamentosService;
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

    @Autowired
    private PagamentosService pagamentosService;

    // 🔹 Listar todos os pagamentos
    @GetMapping
    public List<Pagamentos> listarTodos() {
        return pagamentosRepository.findAll();
    }

    @PostMapping
    public void cadastrarPagamentos(@RequestParam PagamentoDto dto) {
        pagamentosService.cadastrarPagamentos(dto);
    }

    @PutMapping
    public void atualizarPagamentos(@RequestParam PagamentoDto dto){
        pagamentosService.atualizarPagamentos(dto);
    }

    // 🔹 Buscar pagamento por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pagamentos> buscarPorId(@PathVariable Long id) {
        Optional<Pagamentos> pagamento = pagamentosRepository.findById(id);
        return pagamento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
