package com.example.demo.controller;

import com.example.demo.model.Estabelecimentos;
import com.example.demo.model.Funcionarios;
import com.example.demo.repository.EstabelecimentosRepository;
import com.example.demo.repository.FuncionariosRepository;
import com.example.demo.service.EstabelecimentosService;
import com.example.demo.service.FuncionariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionariosController {

    @Autowired
    private FuncionariosService funcionariosService;

    @Autowired
    private FuncionariosRepository funcionariosRepository;

    // 🔹 Listar todos os estabelecimentos
    @GetMapping
    public List<Funcionarios> listarFuncionarios() {
        return funcionariosRepository.findAll();
    }
}
