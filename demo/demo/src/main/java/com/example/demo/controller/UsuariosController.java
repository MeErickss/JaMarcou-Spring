package com.example.demo.controller;

import com.example.demo.dto.LoginDto;
import com.example.demo.model.Usuarios;
import com.example.demo.repository.UsuariosRepository;
import com.example.demo.service.UsuariosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

    private final UsuariosRepository usuariosRepository;
    private final UsuariosService usuariosService;

    public UsuariosController(UsuariosRepository usuariosRepository, UsuariosService usuariosService) {
        this.usuariosRepository = usuariosRepository;
        this.usuariosService = usuariosService;
    }

    @GetMapping
    public ResponseEntity<List<Usuarios>> listarTodos() {
        return ResponseEntity.ok(usuariosRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> buscarPorId(@PathVariable Long id) {
        Optional<Usuarios> usuario = usuariosRepository.findById(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/login")
    public String validarLogin(@RequestBody LoginDto loginDto){
        String token = usuariosService.validarLogin(loginDto);

        if (token == null) {
            return ("Email ou senha inválidos");
        }

        return token;
    }
}
