package com.example.demo.service;

import com.example.demo.model.enumeration.FormaPagamento;
import com.example.demo.model.enumeration.Funcoes;
import com.example.demo.model.enumeration.StatusHorario;
import com.example.demo.model.enumeration.TipoPagamento;
import com.example.demo.repository.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class SeedService implements ApplicationRunner {

    private final CategoriasService categoriasService;
    private final EstabelecimentosService estabelecimentosService;
    private final UsuariosService usuariosService;
    private final LocaisService locaisService;
    private final HorariosService horariosService;
    private final PagamentosService pagamentosService;
    private final AvaliacoesService avaliacoesService;
    private final ServicosService servicosService;
    private final CategoriasRepository categoriasRepository;

    // Injeção por construtor
    public SeedService(
            CategoriasService categoriasService,
            EstabelecimentosService estabelecimentosService,
            UsuariosService usuariosService,
            LocaisService locaisService,
            HorariosService horariosService,
            PagamentosService pagamentosService,
            AvaliacoesService avaliacoesService,
            ServicosService servicosService,
            CategoriasRepository categoriasRepository
    ) {
        this.categoriasService = categoriasService;
        this.estabelecimentosService = estabelecimentosService;
        this.usuariosService = usuariosService;
        this.locaisService = locaisService;
        this.horariosService = horariosService;
        this.pagamentosService = pagamentosService;
        this.avaliacoesService = avaliacoesService;
        this.servicosService = servicosService;
        this.categoriasRepository = categoriasRepository;
    }

    @Override
    public void run(ApplicationArguments args) {

        if (categoriasRepository.count() > 0) {
            return; // já tem seed, não roda de novo
        }

        // ===================== CATEGORIAS =====================
        categoriasService.cadastrarCategoria("Cortes e serviços de barbearia", "Barbearia");
        categoriasService.cadastrarCategoria("Cabelos, unhas e estética", "Salão de Beleza");
        categoriasService.cadastrarCategoria("Cuidados com a pele", "Estética Facial");
        categoriasService.cadastrarCategoria("Cuidados com o corpo", "Clínica de Estética");
        categoriasService.cadastrarCategoria("Massagens terapêuticas", "Massoterapia");
        categoriasService.cadastrarCategoria("Depilação", "Depilação");
        categoriasService.cadastrarCategoria("Tratamentos capilares", "Cabelos");

        // ===================== LOCAIS =====================
        locaisService.cadastrarLocal(123, "12345-678", "Rua A", "Sala 1", -23.55052);
        locaisService.cadastrarLocal(456, "98765-432", "Rua B", "Sala 2", -23.55100);
        locaisService.cadastrarLocal(789, "11111-222", "Rua C", "Sala 3", -23.55200);
        locaisService.cadastrarLocal(321, "22222-333", "Av Paulista", "Andar 5", -23.55300);
        locaisService.cadastrarLocal(654, "44444-555", "Rua das Flores", "Loja 10", -23.55400);

        // ===================== ESTABELECIMENTOS =====================
        estabelecimentosService.cadastrarEstabelecimento(1L, 1L, "https://via.placeholder.com/150", LocalDateTime.now(), "Barber Shop", "123456");
        estabelecimentosService.cadastrarEstabelecimento(2L, 2L, "https://via.placeholder.com/150", LocalDateTime.now(), "Beauty Salon", "123456");
        estabelecimentosService.cadastrarEstabelecimento(3L, 3L, "https://via.placeholder.com/150", LocalDateTime.now(), "Spa Facial", "123456");
        estabelecimentosService.cadastrarEstabelecimento(4L, 4L, "https://via.placeholder.com/150", LocalDateTime.now(), "Clínica Corpo & Saúde", "123456");
        estabelecimentosService.cadastrarEstabelecimento(5L, 5L, "https://via.placeholder.com/150", LocalDateTime.now(), "Massagens Relax", "123456");

        // ===================== USUÁRIOS =====================
        usuariosService.cadastrarUsuario(LocalDateTime.of(2000, 1, 1, 0, 0), "11111111111", 1L, "https://via.placeholder.com/100", "João", "123", "Silva", "ATIVO","joao@gmail.com", List.of(Funcoes.CLIENTE));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1995, 5, 10, 0, 0), "22222222222", 1L, "https://via.placeholder.com/100", "Pedro", "123", "Almeida", "ATIVO","pedro@gmail.com", List.of(Funcoes.CLIENTE));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1998, 8, 20, 0, 0), "33333333333", 2L, "https://via.placeholder.com/100", "Maria", "123", "Oliveira", "ATIVO","maria@gmail.com", List.of(Funcoes.CLIENTE));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1985, 3, 15, 0, 0), "44444444444", 3L, "https://via.placeholder.com/100", "Ana", "123", "Costa", "ATIVO","ana@gmail.com", List.of(Funcoes.CLIENTE));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1992, 7, 25, 0, 0), "55555555555", 3L, "https://via.placeholder.com/100", "Lucas", "123", "Souza", "ATIVO","lucas@gmail.com", List.of(Funcoes.CLIENTE));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1988, 12, 5, 0, 0), "66666666666", 4L, "https://via.placeholder.com/100", "Clara", "123", "Mendes", "ATIVO","clara@gmail.com", List.of(Funcoes.CLIENTE));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1999, 6, 18, 0, 0), "77777777777", 5L, "https://via.placeholder.com/100", "Diego", "123", "Santos", "ATIVO","diego@gmail.com", List.of(Funcoes.CLIENTE));

        // ===================== HORÁRIOS =====================
        horariosService.cadastrarHorario(StatusHorario.AGENDADO, LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(1).plusHours(1), LocalDateTime.now(),  1L, 1L);
        horariosService.cadastrarHorario(StatusHorario.CONCLUIDO, LocalDateTime.now().minusDays(2), LocalDateTime.now().minusDays(2).plusHours(1), LocalDateTime.now().minusDays(2), 2L, 3L);
        horariosService.cadastrarHorario(StatusHorario.CANCELADO, LocalDateTime.now().minusDays(3), LocalDateTime.now().minusDays(3).plusHours(2), LocalDateTime.now().minusDays(3), 3L, 4L);
        horariosService.cadastrarHorario(StatusHorario.AGENDADO, LocalDateTime.now().plusDays(5), LocalDateTime.now().plusDays(5).plusHours(1), LocalDateTime.now(), 4L, 6L);
        horariosService.cadastrarHorario(StatusHorario.CONCLUIDO, LocalDateTime.now().minusDays(7), LocalDateTime.now().minusDays(7).plusHours(1), LocalDateTime.now().minusDays(7), 5L, 7L);

        // ===================== PAGAMENTOS =====================
        pagamentosService.cadastrarPagamentos(FormaPagamento.CARTAO, 1L, TipoPagamento.AVISTA, 150.0f, LocalDateTime.now(), "PG001");
        pagamentosService.cadastrarPagamentos(FormaPagamento.PIX, 2L, TipoPagamento.AVISTA, 200.0f, LocalDateTime.now(), "PG002");
        pagamentosService.cadastrarPagamentos(FormaPagamento.DINHEIRO, 3L, TipoPagamento.PARCELADO, 300.0f, LocalDateTime.now(), "PG003");
        pagamentosService.cadastrarPagamentos(FormaPagamento.CARTAO, 4L, TipoPagamento.AVISTA, 250.0f, LocalDateTime.now(), "PG004");
        pagamentosService.cadastrarPagamentos(FormaPagamento.PIX, 5L, TipoPagamento.PARCELADO, 500.0f, LocalDateTime.now(), "PG005");

        // ===================== AVALIAÇÕES =====================
        avaliacoesService.cadastrarAvaliacao(4.5f, 1L, 1L);
        avaliacoesService.cadastrarAvaliacao(5.0f, 2L, 2L);
        avaliacoesService.cadastrarAvaliacao(3.5f, 3L, 3L);
        avaliacoesService.cadastrarAvaliacao(4.8f, 4L, 4L);
        avaliacoesService.cadastrarAvaliacao(2.5f, 5L, 5L);

        // ===================== SERVIÇOS =====================
        servicosService.cadastrarServico("Corte simples masculino", "Corte Masculino", 50f, 1L);
        servicosService.cadastrarServico("Barba completa", "Barba", 40f, 1L);
        servicosService.cadastrarServico("Manicure completa", "Manicure", 70f, 2L);
        servicosService.cadastrarServico("Tratamento facial", "Limpeza de pele", 120f, 3L);
        servicosService.cadastrarServico("Massagem relaxante", "Massagem", 150f, 5L);
        servicosService.cadastrarServico("Progressiva capilar", "Tratamento Capilar", 250f, 2L);
        servicosService.cadastrarServico("Depilação completa", "Depilação", 180f, 4L);

        // ===================== ASSOCIAÇÃO SERVIÇOS x USUÁRIOS =====================
        servicosService.associarUsuarios(1L,1L);
        servicosService.associarUsuarios(1L,2L);
        servicosService.associarUsuarios(1L,3L);
        servicosService.associarUsuarios(2L,4L);
        servicosService.associarUsuarios(3L,1L);
        servicosService.associarUsuarios(3L,5L);
        servicosService.associarUsuarios(2L,2L);
        servicosService.associarUsuarios(4L,6L);
        servicosService.associarUsuarios(5L,7L);

        // ===================== ASSOCIAÇÃO SERVIÇOS x ESTABELECIMENTOS =====================
        estabelecimentosService.associarServicos(1L, 1L); // Corte simples -> Barber Shop
        estabelecimentosService.associarServicos(2L, 1L); // Barba completa -> Barber Shop
        estabelecimentosService.associarServicos(3L, 2L); // Manicure completa -> Beauty Salon
        estabelecimentosService.associarServicos(6L, 2L); // Progressiva capilar -> Beauty Salon
        estabelecimentosService.associarServicos(4L, 3L); // Tratamento facial -> Spa Facial
        estabelecimentosService.associarServicos(7L, 4L); // Depilação completa -> Clínica Corpo & Saúde
        estabelecimentosService.associarServicos(5L, 5L); // Massagem relaxante -> Massagens Relax

        System.out.println("Seed inicial expandido inserido com sucesso!");
    }

}
