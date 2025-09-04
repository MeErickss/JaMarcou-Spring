package com.example.demo.controller;

import com.example.demo.dto.AgendamentosDto;
import com.example.demo.model.Agendamentos;
import com.example.demo.repository.AgendamentosRepository;
import com.example.demo.service.AgendamentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentosController {

    @Autowired
    private AgendamentosRepository agendamentosRepository;

    @Autowired
    private AgendamentosService agendamentosService;

    // Listar todos os agendamentos
    @GetMapping
    public List<Agendamentos> listarTodos() {
        return agendamentosRepository.findAll();
    }
}
