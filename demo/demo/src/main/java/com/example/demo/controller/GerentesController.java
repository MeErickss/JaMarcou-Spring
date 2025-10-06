package com.example.demo.controller;

import com.example.demo.model.Funcionarios;
import com.example.demo.model.Gerentes;
import com.example.demo.repository.FuncionariosRepository;
import com.example.demo.repository.GerentesRepository;
import com.example.demo.service.FuncionariosService;
import com.example.demo.service.GerentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/gerentes")
public class GerentesController {

    @Autowired
    private GerentesService gerentesService;

    @Autowired
    private GerentesRepository gerentesRepository;

    // 🔹 Listar todos os estabelecimentos
    @GetMapping
    public List<Gerentes> listarGerentes() {
        return gerentesRepository.findAll();
    }
}
