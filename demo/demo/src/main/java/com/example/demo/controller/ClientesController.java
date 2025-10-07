package com.example.demo.controller;

import com.example.demo.model.AgendamentosLocacao;
import com.example.demo.model.AgendamentosServico;
import com.example.demo.model.Clientes;
import com.example.demo.repository.AgendamentosLocacaoRepository;
import com.example.demo.repository.AgendamentosServicoRepository;
import com.example.demo.repository.ClientesRepository;
import com.example.demo.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClientesController {

    @Autowired
    private ClientesService clientesService;

    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private AgendamentosLocacaoRepository agendamentosLocacaoRepository;

    @Autowired
    private AgendamentosServicoRepository agendamentosServicoRepository;

    @GetMapping
    public List<Clientes> listarClientes() {
        return clientesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Clientes>> getClienteById(@PathVariable Long id) {
        Optional<Clientes> clientes = clientesRepository.findById(id);
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}/raw")
    public ResponseEntity<Clientes> getClientesRaw(@PathVariable Long id) {
        Optional<Clientes> clientesOpt = clientesRepository.findBasicById(id);

        if (clientesOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(clientesOpt.get());
    }

    // GET /api/estabelecimentos/{id}/servicos
    @GetMapping("/{id}/agendamentosServico")
    public ResponseEntity<List<AgendamentosServico>> getAgendamentosServico(@PathVariable Long id) {
        if (!clientesRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Clientes clientes = clientesRepository.findById(id).orElse(null);

        List<AgendamentosServico> agendamentosServico = agendamentosServicoRepository.findByCliente(clientes);
        return ResponseEntity.ok(agendamentosServico);
    }

    // GET /api/estabelecimentos/{id}/servicos
    @GetMapping("/{id}/agendamentosLocacao")
    public ResponseEntity<List<AgendamentosLocacao>> getAgendamentosLocacao(@PathVariable Long id) {
        if (!clientesRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Clientes clientes = clientesRepository.findById(id).orElse(null);

        List<AgendamentosLocacao> agendamentosLocacao = agendamentosLocacaoRepository.findByCliente(clientes);
        return ResponseEntity.ok(agendamentosLocacao);
    }

}
