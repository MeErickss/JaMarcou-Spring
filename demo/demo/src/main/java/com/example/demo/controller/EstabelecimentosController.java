package com.example.demo.controller;

import com.example.demo.dto.CadastroDto;
import com.example.demo.dto.EstabelecimentosDto;
import com.example.demo.model.Estabelecimentos;
import com.example.demo.model.Usuarios;
import com.example.demo.model.enumeration.Funcoes;
import com.example.demo.repository.EstabelecimentosRepository;
import com.example.demo.service.EstabelecimentosService;
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

    @Autowired
    private EstabelecimentosService estabelecimentosService;

    // 🔹 Listar todos os estabelecimentos
    @GetMapping
    public List<Estabelecimentos> listarTodos() {
        return estabelecimentosRepository.findAll();
    }

    @PostMapping
    public void cadastrarEstabelecimentos(@RequestBody EstabelecimentosDto dto) {
        estabelecimentosService.cadastrarEstabelecimento(dto);
    }

    @PostMapping("/cadastro")
    public void cadastrarEstabelecimentos(@RequestBody CadastroDto dto) {
        estabelecimentosService.inserirEstabelecimento(dto);
    }

    @PutMapping
    public void atualizarEstabelecimentos(@RequestBody EstabelecimentosDto dto){
        estabelecimentosService.atualizarEstabelecimento(dto);
    }

    // 🔹 Buscar estabelecimento por ID
    @GetMapping("/{id}")
    public ResponseEntity<Estabelecimentos> buscarPorId(@PathVariable Long id) {
        Optional<Estabelecimentos> estabelecimento = estabelecimentosRepository.findById(id);
        return estabelecimento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/relacoes")
    public ResponseEntity<List<Estabelecimentos>> listarRelacoesEstabelecimentos(){
            List<Estabelecimentos> estabelecimento = estabelecimentosRepository.findAllWithUsuarios();
        return ResponseEntity.ok(estabelecimento);
    }

    @GetMapping("/gerente/{id:\\d+}")
    public ResponseEntity<List<Estabelecimentos>> listarGerente(@PathVariable Long id){
        List<Estabelecimentos> estabelecimento = estabelecimentosRepository.findEstabelecimentosOndeUsuarioEhGerente(id);
        return ResponseEntity.ok(estabelecimento);
    }

    @GetMapping("/funcionarios/{id:\\d+}")
    public ResponseEntity<List<Usuarios>> listarFuncionarios(@PathVariable Long id){
        List<Usuarios> estabelecimento = estabelecimentosRepository.findFuncionariosDoEstabelecimentoDoGerente(id, Funcoes.FUNCIONARIO);
        return ResponseEntity.ok(estabelecimento);
    }

}
