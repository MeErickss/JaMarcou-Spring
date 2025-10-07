package com.example.demo.controller;

import com.example.demo.model.Estabelecimentos;
import com.example.demo.model.HorariosLocacao;
import com.example.demo.model.Locacoes;
import com.example.demo.repository.EstabelecimentosRepository;
import com.example.demo.repository.HorariosLocacaoRepository;
import com.example.demo.repository.LocacoesRepository;
import com.example.demo.service.LocacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/locacoes")
public class LocacoesController {

    @Autowired
    private LocacoesService locacoesService;

    @Autowired
    private LocacoesRepository locacoesRepository;

    @Autowired
    private EstabelecimentosRepository estabelecimentosRepository;

    @Autowired
    private HorariosLocacaoRepository horariosLocacaoRepository;

    // 🔹 Listar todos os horários
    @GetMapping
    public List<Locacoes> listarLocacoes() {
        return locacoesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Locacoes>> getLocacaoById(@PathVariable Long id) {
        Optional<Locacoes> locacoes = locacoesRepository.findById(id);
        return ResponseEntity.ok(locacoes);
    }

    @GetMapping("/{id}/raw")
    public ResponseEntity<Locacoes> getLocacoesRaw(@PathVariable Long id) {
        Optional<Locacoes> locacoesOpt = locacoesRepository.findBasicById(id);

        if (locacoesOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(locacoesOpt.get());
    }

    // GET /api/estabelecimentos/{id}/servicos
    @GetMapping("/{id}/estabelecimento")
    public ResponseEntity<Estabelecimentos> getEstabelecimentos(@PathVariable Long id) {
        if (!locacoesRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Locacoes locacoes = locacoesRepository.findById(id).orElse(null);

        Estabelecimentos estabelecimentos = estabelecimentosRepository.findByLocacoes(locacoes);
        return ResponseEntity.ok(estabelecimentos);
    }

    // GET /api/estabelecimentos/{id}/servicos
    @GetMapping("/{id}/horarios")
    public ResponseEntity<List<HorariosLocacao>> getHorarios(@PathVariable Long id) {
        if (!locacoesRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Locacoes locacoes = locacoesRepository.findById(id).orElse(null);

        List<HorariosLocacao> horariosLocacaos = horariosLocacaoRepository.findByLocacao(locacoes);
        return ResponseEntity.ok(horariosLocacaos);
    }
}