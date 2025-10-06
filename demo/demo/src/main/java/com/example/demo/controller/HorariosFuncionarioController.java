package com.example.demo.controller;

import com.example.demo.dto.HorariosFuncionarioDto;
import com.example.demo.model.HorariosFuncionario;
import com.example.demo.model.enumeration.StatusHorario;
import com.example.demo.repository.HorariosFuncionarioRepository;
import com.example.demo.service.HorariosFuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horariosfuncionarios")
public class HorariosFuncionarioController {

    @Autowired
    private HorariosFuncionarioRepository horariosFuncionarioRepository;

    @Autowired
    private HorariosFuncionarioService horariosFuncionarioService;

    // 🔹 Listar todos os horários
    @GetMapping
    public List<HorariosFuncionario> listarHorariosFuncionario() {
        return horariosFuncionarioRepository.findAll();
    }
}
