package com.example.demo.controller;

import com.example.demo.model.AgendamentosLocacao;
import com.example.demo.model.Categorias;
import com.example.demo.repository.AgendamentosLocacaoRepository;
import com.example.demo.repository.AgendamentosServicoRepository;
import com.example.demo.service.AgendamentosLocacaoService;
import com.example.demo.service.AgendamentosServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/agendamentoslocacao")
public class AgendamentosLocacaoController {

    @Autowired
    private AgendamentosLocacaoService agendamentosLocacaoService;

    @Autowired
    private AgendamentosLocacaoRepository agendamentosLocacaoRepository;

    @GetMapping
    public List<AgendamentosLocacao> listarAgendamentosLocacao() {
        return agendamentosLocacaoRepository.findAll();
    }
}
