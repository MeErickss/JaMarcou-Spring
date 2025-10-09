package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.model.enumeration.DiasSemana;
import com.example.demo.model.enumeration.FormaPagamento;
import com.example.demo.model.enumeration.StatusHorario;
import com.example.demo.model.enumeration.TipoPagamento;
import com.example.demo.repository.CategoriasRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;


@Service
@Transactional
public class SeedService implements ApplicationRunner {

    private final CategoriasRepository categoriasRepository;
    private final LocaisService locaisService;
    private final EstabelecimentosService estabelecimentosService;
    private final ClientesService clientesService;
    private final FuncionariosService funcionariosService;
    private final GerentesService gerentesService;
    private final ServicosService servicosService;
    private final LocacoesService locacoesService;
    private final HorariosFuncionarioService horariosFuncionarioService;
    private final HorariosLocacaoService horariosLocacaoService;
    private final AgendamentosServicoService agendamentosServicoService;
    private final AgendamentosLocacaoService agendamentosLocacaoService;
    private final PagamentosService pagamentosService;
    private final AvaliacoesService avaliacoesService;

    public SeedService(
            CategoriasRepository categoriasRepository,
            LocaisService locaisService,
            EstabelecimentosService estabelecimentosService,
            ClientesService clientesService,
            FuncionariosService funcionariosService,
            GerentesService gerentesService,
            ServicosService servicosService,
            LocacoesService locacoesService,
            HorariosFuncionarioService horariosFuncionarioService,
            HorariosLocacaoService horariosLocacaoService,
            AgendamentosServicoService agendamentosServicoService,
            AgendamentosLocacaoService agendamentosLocacaoService,
            PagamentosService pagamentosService,
            AvaliacoesService avaliacoesService
    ) {
        this.categoriasRepository = categoriasRepository;
        this.locaisService = locaisService;
        this.estabelecimentosService = estabelecimentosService;
        this.clientesService = clientesService;
        this.funcionariosService = funcionariosService;
        this.gerentesService = gerentesService;
        this.servicosService = servicosService;
        this.locacoesService = locacoesService;
        this.horariosFuncionarioService = horariosFuncionarioService;
        this.horariosLocacaoService = horariosLocacaoService;
        this.agendamentosServicoService = agendamentosServicoService;
        this.agendamentosLocacaoService = agendamentosLocacaoService;
        this.pagamentosService = pagamentosService;
        this.avaliacoesService = avaliacoesService;
    }

    @Override
    public void run(ApplicationArguments args) {
        // não rodar seed se já houver categorias
        if (categoriasRepository.count() > 0) return;

        // ===== CATEGORIAS =====
        Categorias saude = new Categorias();
        saude.setNome("SAUDE");
        saude.setDescricao("Serviços de saúde e clínicas");
        categoriasRepository.save(saude);

        Categorias estetica = new Categorias();
        estetica.setNome("ESTETICA");
        estetica.setDescricao("Salões, barbearias, estética");
        categoriasRepository.save(estetica);

        Categorias entretenimento = new Categorias();
        entretenimento.setNome("ENTRETENIMENTO");
        entretenimento.setDescricao("Lazer e entretenimento");
        categoriasRepository.save(entretenimento);

        Categorias esporte = new Categorias();
        esporte.setNome("ESPORTE");
        esporte.setDescricao("Quadras, arenas, atividades esportivas");
        categoriasRepository.save(esporte);

        Categorias outros = new Categorias();
        outros.setNome("OUTROS");
        outros.setDescricao("Categoria genérica");
        categoriasRepository.save(outros);

        // ===== LOCAIS =====
        // assinaturas: locaisService.cadastrarLocal(Integer numero, String cep, String rua, String complemento, String cidade, String bairro, String estado)
        locaisService.cadastrarLocal(123, "12345-678", "Rua A", "Sala 1", "Araruna", "Araucaria", "Parana");
        locaisService.cadastrarLocal(456, "98765-432", "Rua B", "Sala 2", "Araruna", "Araucaria", "Parana");
        locaisService.cadastrarLocal(789, "11111-222", "Rua C", "Sala 3", "Araruna", "Araucaria", "Parana");
        locaisService.cadastrarLocal(321, "22222-333", "Av Paulista", "Andar 5", "Sao Paulo", "Centro", "SP");
        locaisService.cadastrarLocal(654, "44444-555", "Rua das Flores", "Loja 10", "Curitiba", "Batel", "Parana");

        // ===== ESTABELECIMENTOS =====
        // createEstabelecimento(Long categoriaId, Long localId, String nome, String cnpj, OffsetDateTime dataCriacao, String senha, String telefone, String linkImg, String descricao)
        estabelecimentosService.createEstabelecimento(estetica.getId(), 1L, "Barber Shop", "11111111111111", OffsetDateTime.now(), "123456", "44 99809-1064", "https://thebarbersonline.com/wp-content/uploads/2019/03/IMG_0216-1.jpg", "Barbearia local");
        estabelecimentosService.createEstabelecimento(estetica.getId(), 2L, "Beauty Salon", "22222222222222", OffsetDateTime.now(), "123456", "44 99809-1065", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNvSVGhi22rBuYde6KyjpiwDKQXeXq1rfTaw&s", "Salão de beleza");
        estabelecimentosService.createEstabelecimento(estetica.getId(), 3L, "Spa Facial", "33333333333333", OffsetDateTime.now(), "123456", "44 99809-1066", "https://cdn.awsli.com.br/2500x2500/1697/1697589/produto/79094733/b2cbe15641.jpg", "Spa Facial");
        estabelecimentosService.createEstabelecimento(saude.getId(), 4L, "Clínica Corpo & Saúde", "44444444444444", OffsetDateTime.now(), "123456", "44 99809-1067", "https://codigomed.com/wp-content/uploads/2017/03/estrutura-clinica.jpg", "Clínica");
        estabelecimentosService.createEstabelecimento(outros.getId(), 5L, "Massagens Relax", "55555555555555", OffsetDateTime.now(), "123456", "44 99809-1068", "https://fly.metroimg.com/upload/q_85,w_700/https://uploads.metroimg.com/wp-content/uploads/2018/05/10155627/massagem.jpg", "Massoterapia");

        // ===== USUÁRIOS (CLIENTES) =====
        // createCliente(email, nome, sobrenome, cpf, senha, dataNascimento, linkImg, statusUsuario)
        Clientes c1 = clientesService.createCliente("joao@gmail.com","João","Silva","11111111111","123", LocalDateTime.of(2000,1,1,0,0), "https://via.placeholder.com/100","44 99809-1069","ATIVO");
        Clientes c2 = clientesService.createCliente("pedro@gmail.com","Pedro","Almeida","22222222222","123", LocalDateTime.of(1995,5,10,0,0),"https://via.placeholder.com/100","44 99809-1070","ATIVO");
        Clientes c3 = clientesService.createCliente("maria@gmail.com","Maria","Oliveira","33333333333","123", LocalDateTime.of(1998,8,20,0,0),"https://via.placeholder.com/100","44 99809-1071","ATIVO");
        Clientes c4 = clientesService.createCliente("ana@gmail.com","Ana","Costa","44444444444","123", LocalDateTime.of(1985,3,15,0,0),"https://via.placeholder.com/100","44 99809-1072","ATIVO");
        Clientes c5 = clientesService.createCliente("lucas@gmail.com","Lucas","Souza","55555555555","123", LocalDateTime.of(1992,7,25,0,0),"https://via.placeholder.com/100","44 99809-1073","ATIVO");
        Clientes c6 = clientesService.createCliente("clara@gmail.com","Clara","Mendes","66666666666","123", LocalDateTime.of(1988,12,5,0,0),"https://via.placeholder.com/100","44 99809-1073","ATIVO");
        Clientes c7 = clientesService.createCliente("diego@gmail.com","Diego","Santos","77777777777","123", LocalDateTime.of(1999,6,18,0,0),"https://via.placeholder.com/100","44 99809-1074","");

        // ===== FUNCIONÁRIOS E GERENTES =====
        // Note: precisamos criar Funcionarios (prestadores) para associar aos serviços e gerentes que terão equipe.
        // createFuncionario(email,nome,sobrenome,cpf,senha,dataNascimento,linkImg,statusUsuario,estabelecimentoId,dataInicioContrato,dataFimContrato)
        Funcionarios f1 = funcionariosService.createFuncionario("f1@barber.com","Carlos","Barber","10101010101","secret", LocalDateTime.of(1990,4,2,0,0), "https://via.placeholder.com/100","ATIVO", 1L, LocalDateTime.now().minusYears(1), null,"44 99809-1075");
        Funcionarios f2 = funcionariosService.createFuncionario("f2@barber.com","Rafael","Cabeleireiro","12121212121","secret", LocalDateTime.of(1992,5,5,0,0), "https://via.placeholder.com/100","ATIVO", 1L, LocalDateTime.now().minusMonths(6), null,"44 99809-1076");
        Funcionarios f3 = funcionariosService.createFuncionario("f3@beauty.com","Beatriz","Manicure","13131313131","secret", LocalDateTime.of(1993,3,4,0,0), "https://via.placeholder.com/100","ATIVO", 2L, LocalDateTime.now().minusMonths(3), null,"44 99809-1077");
        Funcionarios f4 = funcionariosService.createFuncionario("f4@spa.com","Marina","Estetica","14141414141","secret", LocalDateTime.of(1991,12,12,0,0), "https://via.placeholder.com/100","ATIVO", 3L, LocalDateTime.now().minusMonths(2), null,"44 99809-1078");
        Funcionarios f5 = funcionariosService.createFuncionario("f5@massagem.com","Patrícia","Massoterapeuta","15151515151","secret", LocalDateTime.of(1998,1,25,0,0), "https://via.placeholder.com/100","ATIVO", 5L, LocalDateTime.now().minusDays(20), null,"44 99809-1079");

        // Gerentes
        Gerentes g1 = gerentesService.createGerente("ger1@barber.com","Rafael","Manager","18181818181","gerpass", LocalDateTime.of(1989,7,3,0,0), "https://via.placeholder.com/100","ATIVO", 1L, "44 99809-1080");
        Gerentes g2 = gerentesService.createGerente("ger2@beauty.com","Beatriz","Manager","19191919191","gerpass", LocalDateTime.of(1994,10,11,0,0), "https://via.placeholder.com/100","ATIVO", 2L, "44 99809-1080");

        // ===== SERVIÇOS (cada serviço precisa de estabelecimento + prestador (Funcionarios)) =====
        // createServico(String nome, String descricao, Float valor, Long quantidadeDisponivel, Long estabelecimentoId, Long prestadorId)
        Servicos s1 = servicosService.createServico("Corte simples masculino", "Corte Masculino", 50f, 100L, 1L, f1.getId());
        Servicos s2 = servicosService.createServico("Barba completa", "Barba", 40f, 100L, 1L, f2.getId());
        Servicos s3 = servicosService.createServico("Manicure completa", "Manicure", 70f, 100L, 2L, f3.getId());
        Servicos s4 = servicosService.createServico("Tratamento facial", "Limpeza de pele", 120f, 50L, 3L, f4.getId());
        Servicos s5 = servicosService.createServico("Massagem relaxante", "Massagem", 150f, 30L, 5L, f5.getId());

        // ===== LOCAÇÕES (quadras/salas) =====
        Locacoes l1 = locacoesService.createLocacao("Quadra 1", "Quadra de Beach Tennis 1", 60f, 5L); // establishment 6 assumed for sports
        Locacoes l2 = locacoesService.createLocacao("Quadra 2", "Quadra de Beach Tennis 2", 60f, 5L);

        // ===== HORÁRIOS FUNCIONÁRIO =====
        // createHorarioFuncionario(StatusHorario, Timestamp dataInicio, Timestamp dataFim, LocalDateTime dataMarcacao, Long estabelecimentoId, Long funcionarioId, DiasSemana)
        horariosFuncionarioService.createHorarioFuncionario(StatusHorario.LIVRE, Timestamp.valueOf(LocalDateTime.now().plusDays(2)), Timestamp.valueOf(LocalDateTime.now().plusDays(2).plusHours(1)), LocalDateTime.now(), 1L, f1.getId(), DiasSemana.SEGUNDA);
        horariosFuncionarioService.createHorarioFuncionario(StatusHorario.LIVRE, Timestamp.valueOf(LocalDateTime.now().plusDays(3)), Timestamp.valueOf(LocalDateTime.now().plusDays(3).plusHours(1)), LocalDateTime.now(), 1L, f2.getId(), DiasSemana.TERCA);
        horariosFuncionarioService.createHorarioFuncionario(StatusHorario.LIVRE, Timestamp.valueOf(LocalDateTime.now().plusDays(4)), Timestamp.valueOf(LocalDateTime.now().plusDays(4).plusHours(1)), LocalDateTime.now(), 2L, f3.getId(), DiasSemana.QUARTA);
        horariosFuncionarioService.createHorarioFuncionario(StatusHorario.LIVRE, Timestamp.valueOf(LocalDateTime.now().plusDays(5)), Timestamp.valueOf(LocalDateTime.now().plusDays(5).plusHours(1)), LocalDateTime.now(), 3L, f4.getId(), DiasSemana.QUINTA);

        // ===== HORÁRIOS LOCAÇÃO =====
        // createHorarioLocacao(DiasSemana, Timestamp dataInicio, Timestamp dataFim, Long locacaoId, LocalDateTime dataCriacao, StatusHorario)
        horariosLocacaoService.createHorarioLocacao(DiasSemana.SABADO, Timestamp.valueOf(LocalDateTime.now().plusDays(2)), Timestamp.valueOf(LocalDateTime.now().plusDays(2).plusHours(2)), l1.getId(), LocalDateTime.now(), StatusHorario.LIVRE);
        horariosLocacaoService.createHorarioLocacao(DiasSemana.DOMINGO, Timestamp.valueOf(LocalDateTime.now().plusDays(3)), Timestamp.valueOf(LocalDateTime.now().plusDays(3).plusHours(2)), l2.getId(), LocalDateTime.now(), StatusHorario.LIVRE);

        // ===== PAGAMENTOS (seed simples via PagamentosService) =====
        // supondo assinatura: pagamentosService.cadastrarPagamentos(FormaPagamento, agendamentoId?, TipoPagamento, valor, LocalDateTime, codigo)
        pagamentosService.cadastrarPagamentos(FormaPagamento.CARTAO, null, TipoPagamento.AVISTA, 150.0f, LocalDateTime.now(), "PG001");
        pagamentosService.cadastrarPagamentos(FormaPagamento.PIX, null, TipoPagamento.AVISTA, 200.0f, LocalDateTime.now(), "PG002");

        // ===== AVALIACOES (seed simples) =====
        avaliacoesService.cadastrarAvaliacao(4.5f, 1L, 1L);
        avaliacoesService.cadastrarAvaliacao(5.0f, 2L, 2L);

        try {
            // Reservas de exemplo (assumindo ids conhecidos; se não, você pode buscar por horário/servico por critérios)
            agendamentosServicoService.createAgendamentoServico(s1.getId(), 1L, c1.getId(), f1.getId(), /*horarioId*/ 1L, "Agendamento demo 1", null, null, null, Boolean.FALSE);
            agendamentosServicoService.createAgendamentoServico(s2.getId(), 1L, c2.getId(), f2.getId(), /*horarioId*/ 2L, "Agendamento demo 2", null, null, null, Boolean.FALSE);
        } catch (Exception ex) {
            // silencio: em alguns setups os ids de horario não correspondem; esses agendamentos são apenas exemplares
            System.out.println("Aviso seed: alguns agendamentos de serviço de exemplo não foram criados (ids de horário). Detalhe: " + ex.getMessage());
        }

        // ===== AGENDAMENTOS DE LOCAÇÃO =====
        try {
            agendamentosLocacaoService.createAgendamentoLocacao(l1.getId(), /*horarioId*/ 1L, c3.getId(), LocalDateTime.now(), StatusHorario.AGENDADO, "Reserva quadra 1", java.math.BigDecimal.valueOf(60.0), FormaPagamento.PIX, LocalDateTime.now(), Boolean.TRUE);
        } catch (Exception ex) {
            System.out.println("Aviso seed: agendamento de locação de exemplo pode ter falhado (ids de horário). Detalhe: " + ex.getMessage());
        }

        System.out.println("Seed atualizado (modelo novo) inserido com sucesso!");
    }
}
