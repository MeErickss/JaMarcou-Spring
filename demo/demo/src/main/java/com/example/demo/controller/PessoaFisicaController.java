package com.example.demo.controller;

import com.example.demo.model.PessoaFisica;
import com.example.demo.repository.PessoaFisicaRepository;
import com.example.demo.service.PessoaFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/pessoafisica")
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaService pessoaFisicaService;

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    // 🔹 Listar todos
    @GetMapping
    public List<PessoaFisica> listarPessoaFisica() {
        return pessoaFisicaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PessoaFisica>> getPessoaFisicaById(@PathVariable Long id) {
        Optional<PessoaFisica> pessoaFisica = pessoaFisicaRepository.findById(id);
        return ResponseEntity.ok(pessoaFisica);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credenciais) {
        try {
            String email = credenciais.get("email");
            String senha = credenciais.get("senha");

            String token = pessoaFisicaService.logar(email, senha);

            return ResponseEntity.ok(Map.of(
                    "token", token,
                    "mensagem", "Login realizado com sucesso"
            ));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("erro", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("erro", "Erro ao processar login"));
        }
    }

    @GetMapping("/validar")
    public ResponseEntity<?> validarToken(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(401).body(Map.of("erro", "Token não fornecido"));
        }

        String token = authHeader.substring(7);
        PessoaFisica pessoa = pessoaFisicaService.validarToken(token);

        if (pessoa == null) {
            return ResponseEntity.status(401).body(Map.of("erro", "Token inválido ou expirado"));
        }

        return ResponseEntity.ok(Map.of(
                "mensagem", "Token válido",
                "usuario", pessoa
        ));
    }
}
