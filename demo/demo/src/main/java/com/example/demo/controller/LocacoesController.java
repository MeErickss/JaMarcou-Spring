package com.example.demo.controller;

import com.example.demo.model.HorariosLocacao;
import com.example.demo.model.Locacoes;
import com.example.demo.repository.HorariosLocacaoRepository;
import com.example.demo.repository.LocacoesRepository;
import com.example.demo.service.HorariosLocacaoService;
import com.example.demo.service.LocacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/locacoes")
public class LocacoesController {

    @Autowired
    private LocacoesService locacoesService;

    @Autowired
    private LocacoesRepository locacoesRepository;

    // 🔹 Listar todos os horários
    @GetMapping
    public List<Locacoes> listarLocacoes() {
        return locacoesRepository.findAll();
    }
}