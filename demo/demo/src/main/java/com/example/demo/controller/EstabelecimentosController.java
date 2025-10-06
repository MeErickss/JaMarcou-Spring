package com.example.demo.controller;

import com.example.demo.dto.CadastroDto;
import com.example.demo.dto.EstabelecimentosDto;
import com.example.demo.model.Estabelecimentos;
import com.example.demo.model.PessoaFisica;
import com.example.demo.repository.EstabelecimentosRepository;
import com.example.demo.service.EstabelecimentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estabelecimentos")
public class EstabelecimentosController {

    @Autowired
    private EstabelecimentosRepository estabelecimentosRepository;

    @Autowired
    private EstabelecimentosService estabelecimentosService;

    // 🔹 Listar todos os estabelecimentos
    @GetMapping
    public List<Estabelecimentos> listarEstabelecimentos() {
        return estabelecimentosRepository.findAll();
    }


}
