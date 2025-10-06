package com.example.demo.controller;

import com.example.demo.dto.PagamentoDto;
import com.example.demo.dto.ServicosDto;
import com.example.demo.model.Servicos;
import com.example.demo.repository.ServicosRepository;
import com.example.demo.service.ServicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicos")
public class ServicosController {

    @Autowired
    private ServicosRepository servicosRepository;

    @Autowired
    private ServicosService servicosService;

    // 🔹 Listar todos os serviços
    @GetMapping
    public List<Servicos> listarServicos() {
        return servicosRepository.findAll();
    }

}
