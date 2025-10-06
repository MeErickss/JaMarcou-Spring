package com.example.demo.controller;

import com.example.demo.dto.AgendamentosServicoDto;
import com.example.demo.model.AgendamentosLocacao;
import com.example.demo.model.AgendamentosServico;
import com.example.demo.model.Categorias;
import com.example.demo.repository.AgendamentosServicoRepository;
import com.example.demo.service.AgendamentosServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendamentosservicos")
public class AgendamentosServicoController {

    @Autowired
    private AgendamentosServicoRepository agendamentosServicoRepository;

    @Autowired
    private AgendamentosServicoService agendamentosServicoService;

    @GetMapping
    public List<AgendamentosServico> listarAgendamentosServicoes() {
        return agendamentosServicoRepository.findAll();
    }


}
