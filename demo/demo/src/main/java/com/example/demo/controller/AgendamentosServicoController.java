package com.example.demo.controller;

import com.example.demo.dto.AgendamentosServicoDto;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.AgendamentosLocacaoService;
import com.example.demo.service.AgendamentosServicoService;
import com.example.demo.service.HorariosFuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/agendamentosservicos")
public class AgendamentosServicoController {

    @Autowired
    private AgendamentosServicoRepository agendamentosServicoRepository;

    @Autowired
    private AgendamentosServicoService agendamentosServicoService;

    @Autowired
    private AgendamentosLocacaoService agendamentosLocacaoService;

    @Autowired
    private AgendamentosLocacaoRepository agendamentosLocacaoRepository;

    @Autowired
    private EstabelecimentosRepository estabelecimentosRepository;

    @Autowired
    private GerentesRepository gerentesRepository;

    @Autowired
    private FuncionariosRepository funcionariosRepository;

    @Autowired
    private ServicosRepository servicosRepository;

    @Autowired
    private LocacoesRepository locacoesRepository;

    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private HorariosFuncionarioRepository horariosFuncionarioRepository;

    @GetMapping
    public List<AgendamentosServico> listarAgendamentosServicoes() {
        return agendamentosServicoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AgendamentosServico>> getAvaliacaoById(@PathVariable Long id) {
        Optional<AgendamentosServico> agendamentosServico = agendamentosServicoRepository.findById(id);
        return ResponseEntity.ok(agendamentosServico);
    }

    @GetMapping("/{id}/raw")
    public ResponseEntity<AgendamentosServico> getAgendamentoServicoRaw(@PathVariable Long id) {
        Optional<AgendamentosServico> agendamentoOpt = agendamentosServicoRepository.findBasicById(id);

        if (agendamentoOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(agendamentoOpt.get());
    }

    // GET /api/estabelecimentos/{id}/gerentes
    @GetMapping("/{id}/servico")
    public ResponseEntity<List<Servicos>> getLocacoes(@PathVariable Long id) {
        // verifica se estabelecimento existe (opcional)
        if (!agendamentosServicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        AgendamentosServico agendamentosServico = agendamentosServicoRepository.findById(id).orElse(null);

        List<Servicos> servicos = servicosRepository.findByAgendamentoServico(agendamentosServico);
        return ResponseEntity.ok(servicos);
    }

    // GET /api/estabelecimentos/{id}/funcionarios
    @GetMapping("/{id}/estabelecimento")
    public ResponseEntity<Estabelecimentos> getEstabelecimentos(@PathVariable Long id) {
        if (!agendamentosServicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Estabelecimentos estabelecimentos = estabelecimentosRepository.findByAgendamentoServicoId(id);
        return ResponseEntity.ok(estabelecimentos);
    }

    // GET /api/estabelecimentos/{id}/servicos
    @GetMapping("/{id}/cliente")
    public ResponseEntity<Clientes> getClientes(@PathVariable Long id) {
        if (!agendamentosServicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        AgendamentosServico agendamentosServico = agendamentosServicoRepository.findById(id).orElse(null);

        Clientes clientes = clientesRepository.findByAgendamentosServico(agendamentosServico);
        return ResponseEntity.ok(clientes);
    }

    // GET /api/estabelecimentos/{id}/servicos
    @GetMapping("/{id}/funcionario")
    public ResponseEntity<Funcionarios> getFuncionarios(@PathVariable Long id) {
        if (!agendamentosServicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Funcionarios funcionarios = funcionariosRepository.findFuncionarioByAgendamentoServico(id);
        return ResponseEntity.ok(funcionarios);
    }

    // GET /api/estabelecimentos/{id}/locacoes
    @GetMapping("/{id}/horario")
    public ResponseEntity<HorariosFuncionario> getHorariosLocacao(@PathVariable Long id) {
        if (!agendamentosServicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        HorariosFuncionario horariosLocacaos = horariosFuncionarioRepository.findByAgendamentosServicoId(id);
        return ResponseEntity.ok(horariosLocacaos);
    }
}
