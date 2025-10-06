package com.example.demo.controller;

import com.example.demo.model.Locacoes;
import com.example.demo.model.PessoaFisica;
import com.example.demo.repository.LocacoesRepository;
import com.example.demo.repository.PessoaFisicaRepository;
import com.example.demo.service.LocacoesService;
import com.example.demo.service.PessoaFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pessoafisica")
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaService pessoaFisicaService;

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    // 🔹 Listar todos os horários
    @GetMapping
    public List<PessoaFisica> listarPessoaFisica() {
        return pessoaFisicaRepository.findAll();
    }
}
