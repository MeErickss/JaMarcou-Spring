package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.model.Usuarios;
import com.example.demo.repository.UsuariosRepository;
import com.example.demo.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosRepository usuariosRepository;
    @Autowired
    private UsuariosService usuariosService;

    @GetMapping
    public ResponseEntity<List<Usuarios>> listarTodos() {
        return ResponseEntity.ok(usuariosRepository.findAll());
    }

    @PostMapping
    public void cadastrarUsuarios(@RequestParam UsuariosDto dto) {
        usuariosService.cadastrarUsuario(dto);
    }

    @PutMapping
    public void atualizarUsuarios(@RequestParam UsuariosDto dto){
        usuariosService.atualizarUsuario(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> buscarPorId(@PathVariable Long id) {
        Optional<Usuarios> usuario = usuariosRepository.findById(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/login")
    public ResponseEntity<?> validarLogin(@RequestBody LoginDto loginDto){
        return ResponseEntity.ok(usuariosService.validarLogin(loginDto));
    }
}
