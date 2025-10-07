package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.repository.HorariosFuncionarioRepository;
import com.example.demo.repository.HorariosLocacaoRepository;
import com.example.demo.repository.LocacoesRepository;
import com.example.demo.service.HorariosFuncionarioService;
import com.example.demo.service.HorariosLocacaoService;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/horarioslocacao")
public class HorariosLocacaoController {

    @Autowired
    private HorariosLocacaoService horariosLocacaoService;

    @Autowired
    private HorariosLocacaoRepository horariosLocacaoRepository;

    @Autowired
    private LocacoesRepository locacoesRepository;

    // 🔹 Listar todos os horários
    @GetMapping
    public List<HorariosLocacao> listarHorariosLocacao() {
        return horariosLocacaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<HorariosLocacao>> getHorariosLocacaoById(@PathVariable Long id) {
        Optional<HorariosLocacao> horariosFuncionario = horariosLocacaoRepository.findById(id);
        return ResponseEntity.ok(horariosFuncionario);
    }

    @GetMapping("/{id}/raw")
    public ResponseEntity<HorariosLocacao> getHorariosLocacaoRaw(@PathVariable Long id) {
        Optional<HorariosLocacao> horariosLocacaoOpt = horariosLocacaoRepository.findBasicById(id);

        if (horariosLocacaoOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(horariosLocacaoOpt.get());
    }

    // GET /api/estabelecimentos/{id}/servicos
    @GetMapping("/{id}/locacao")
    public ResponseEntity<List<Locacoes>> getLocacoes(@PathVariable Long id) {
        if (!horariosLocacaoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        HorariosLocacao horariosLocacao = horariosLocacaoRepository.findById(id).orElse(null);

        List<Locacoes> locacoes = locacoesRepository.findByHorariosLocacao(horariosLocacao);
        return ResponseEntity.ok(locacoes);
    }
}