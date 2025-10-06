package com.example.demo.controller;

import com.example.demo.model.HorariosFuncionario;
import com.example.demo.model.HorariosLocacao;
import com.example.demo.repository.HorariosFuncionarioRepository;
import com.example.demo.repository.HorariosLocacaoRepository;
import com.example.demo.service.HorariosFuncionarioService;
import com.example.demo.service.HorariosLocacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/horarioslocacao")
public class HorariosLocacaoController {

    @Autowired
    private HorariosLocacaoService horariosLocacaoService;

    @Autowired
    private HorariosLocacaoRepository horariosLocacaoRepository;

    // 🔹 Listar todos os horários
    @GetMapping
    public List<HorariosLocacao> listarHorariosLocacao() {
        return horariosLocacaoRepository.findAll();
    }
}