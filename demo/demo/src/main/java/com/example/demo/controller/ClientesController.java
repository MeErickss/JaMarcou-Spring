package com.example.demo.controller;

import com.example.demo.model.AgendamentosServico;
import com.example.demo.model.Clientes;
import com.example.demo.repository.AgendamentosServicoRepository;
import com.example.demo.repository.ClientesRepository;
import com.example.demo.service.AgendamentosServicoService;
import com.example.demo.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClientesController {

    @Autowired
    private ClientesService clientesService;

    @Autowired
    private ClientesRepository clientesRepository;

    @GetMapping
    public List<Clientes> listarClientes() {
        return clientesRepository.findAll();
    }
}
