package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.AgendamentosLocacaoService;
import com.example.demo.service.AgendamentosServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/agendamentoslocacao")
public class AgendamentosLocacaoController {

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
    private HorariosLocacaoRepository horariosLocacaoRepository;


    @GetMapping
    public List<AgendamentosLocacao> listarAgendamentosLocacao() {
        return agendamentosLocacaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AgendamentosLocacao>> getAvaliacaoById(@PathVariable Long id) {
        Optional<AgendamentosLocacao> agendamentosLocacao = agendamentosLocacaoRepository.findById(id);
        return ResponseEntity.ok(agendamentosLocacao);
    }

    @GetMapping("/gerente/{gerenteId}/agendamentos")
    public ResponseEntity<List<AgendamentosLocacao>> listarPorGerente(@PathVariable Long gerenteId) {
        List<AgendamentosLocacao> lista = agendamentosLocacaoRepository.findAllByGerenteEstabelecimento(gerenteId);
        if (lista.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}/raw")
    public ResponseEntity<AgendamentosLocacao> getAgendamentoLocacaoRaw(@PathVariable Long id) {
        Optional<AgendamentosLocacao> agendamentoOpt = agendamentosLocacaoRepository.findBasicById(id);

        if (agendamentoOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(agendamentoOpt.get());
    }

    // GET /api/estabelecimentos/{id}/gerentes
    @GetMapping("/{id}/locacao")
    public ResponseEntity<List<Locacoes>> getLocacoes(@PathVariable Long id) {
        // verifica se estabelecimento existe (opcional)
        if (!agendamentosLocacaoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }


        List<Locacoes> locacoes = locacoesRepository.findByAgendamentoLocacaoId(id);
        return ResponseEntity.ok(locacoes);
    }

    // GET /api/estabelecimentos/{id}/funcionarios
    @GetMapping("/{id}/estabelecimento")
    public ResponseEntity<Estabelecimentos> getEstabelecimentos(@PathVariable Long id) {
        if (!agendamentosLocacaoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Estabelecimentos estabelecimentos = estabelecimentosRepository.findByAgendamentoLocacaoId(id);
        return ResponseEntity.ok(estabelecimentos);
    }

    // GET /api/estabelecimentos/{id}/servicos
    @GetMapping("/{id}/cliente")
    public ResponseEntity<Clientes> getClientes(@PathVariable Long id) {
        if (!agendamentosLocacaoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        AgendamentosLocacao agendamentosLocacao = agendamentosLocacaoRepository.findById(id).orElse(null);

        Clientes clientes = clientesRepository.findByAgendamentosLocacao(agendamentosLocacao);
        return ResponseEntity.ok(clientes);
    }

    // GET /api/estabelecimentos/{id}/locacoes
    @GetMapping("/{id}/horario")
    public ResponseEntity<List<HorariosLocacao>> getHorariosLocacao(@PathVariable Long id) {
        if (!agendamentosLocacaoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        List<HorariosLocacao> horariosLocacaos = horariosLocacaoRepository.findByAgendamentoLocacaoId(id);
        return ResponseEntity.ok(horariosLocacaos);
    }
}
