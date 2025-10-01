package com.example.demo.service;

import com.example.demo.model.enumeration.*;
import com.example.demo.repository.CategoriasRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private final AgendamentosService agendamentosService;
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
            AgendamentosService agendamentosService,
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
        this.agendamentosService = agendamentosService;
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
        locaisService.cadastrarLocal(123, "12345-678", "Rua A", "Sala 1", "Araruna", "Araucaria", "Parana");
        locaisService.cadastrarLocal(456, "98765-432", "Rua B", "Sala 2", "Araruna", "Araucaria", "Parana");
        locaisService.cadastrarLocal(789, "11111-222", "Rua C", "Sala 3", "Araruna", "Araucaria", "Parana");
        locaisService.cadastrarLocal(321, "22222-333", "Av Paulista", "Andar 5", "Araruna", "Araucaria", "Parana");
        locaisService.cadastrarLocal(654, "44444-555", "Rua das Flores", "Loja 10", "Araruna", "Araucaria", "Parana");

        //Integer numero, String cep, String rua, String complemento, String cidade, String Bairro, String estado

        // ===================== ESTABELECIMENTOS =====================
        estabelecimentosService.cadastrarEstabelecimento(1L, 1L, "https://images.unsplash.com/photo-1585747860715-2ba37e788b70?fm=jpg&q=60&w=3000&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8YmFyYmVyc2hvcHxlbnwwfHwwfHx8MA%3D%3D", OffsetDateTime.now(), "Barber Shop", "123456", "44 99809-1064","a");
        estabelecimentosService.cadastrarEstabelecimento(2L, 2L, "https://media.istockphoto.com/id/1856117770/pt/foto/modern-beauty-salon.jpg?s=612x612&w=0&k=20&c=fmGnHKgPpFPjGS1FzQQkSvJ2J-cuvkITHWwnbGhtZeo=", OffsetDateTime.now(), "Beauty Salon", "123456", "44 99809-1064","a");
        estabelecimentosService.cadastrarEstabelecimento(3L, 3L, "https://images.squarespace-cdn.com/content/v1/5b8962ea4eddec1828a9ee2b/0269b17e-d2bf-471f-9352-f8a47812c4f0/Facial-providence-ri.jpg", OffsetDateTime.now(), "Spa Facial", "123456", "44 99809-1064","a");
        estabelecimentosService.cadastrarEstabelecimento(4L, 4L, "https://images.unsplash.com/photo-1629909613654-28e377c37b09?fm=jpg&q=60&w=3000&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8Y2xpbmljfGVufDB8fDB8fHww", OffsetDateTime.now(), "Clínica Corpo & Saúde", "123456", "44 99809-1064","a");
        estabelecimentosService.cadastrarEstabelecimento(5L, 5L, "https://images.squarespace-cdn.com/content/v1/5f2864b6ee63644ee0b157d3/1700953967219-ZG5U9WWAORHK4P0M9PON/Massage+therapist+doing+massage+for+a+woman.jpg", OffsetDateTime.now(), "Massagens Relax", "123456", "44 99809-1064","a");
        estabelecimentosService.cadastrarEstabelecimento(6L, 1L, "https://images.unsplash.com/photo-1556228720-1b3f9d6a2b5d?fm=jpg&q=60&w=3000", OffsetDateTime.now(), "Studio Beleza Plus", "123456", "44 99809-1000","a");
        estabelecimentosService.cadastrarEstabelecimento(7L, 2L, "https://images.unsplash.com/photo-1581579189044-1f1b9d8c3c1b?fm=jpg&q=60&w=3000", OffsetDateTime.now(), "Clinique Estética", "123456", "44 99809-1001","a");
        estabelecimentosService.cadastrarEstabelecimento(2L, 3L, "https://images.unsplash.com/photo-1524758631624-e2822e304c36?fm=jpg&q=60&w=3000", OffsetDateTime.now(), "Hair & Spa", "123456", "44 99809-1002","a");
        estabelecimentosService.cadastrarEstabelecimento(1L, 4L, "https://images.unsplash.com/photo-1506084868230-bb9d95c24759?fm=jpg&q=60&w=3000", OffsetDateTime.now(), "Depilart Clínica", "123456", "44 99809-1003","a");
        estabelecimentosService.cadastrarEstabelecimento(3L, 5L, "https://images.unsplash.com/photo-1542317854-5f4d8f3f9d6b?fm=jpg&q=60&w=3000", OffsetDateTime.now(), "Relax & Massagem", "123456", "44 99809-1004","a");

        // ===================== USUÁRIOS (originais) =====================
        usuariosService.cadastrarUsuario(LocalDateTime.of(2000, 1, 1, 0, 0), "11111111111", 1L, "https://via.placeholder.com/100", "João", "123", "Silva", "ATIVO","joao@gmail.com", new HashSet<>(Set.of(Funcoes.CLIENTE)));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1995, 5, 10, 0, 0), "22222222222", 1L, "https://via.placeholder.com/100", "Pedro", "123", "Almeida", "ATIVO","pedro@gmail.com", new HashSet<>(Set.of(Funcoes.CLIENTE)));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1998, 8, 20, 0, 0), "33333333333", 2L, "https://via.placeholder.com/100", "Maria", "123", "Oliveira", "ATIVO","maria@gmail.com", new HashSet<>(Set.of(Funcoes.CLIENTE)));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1985, 3, 15, 0, 0), "44444444444", 3L, "https://via.placeholder.com/100", "Ana", "123", "Costa", "ATIVO","ana@gmail.com", new HashSet<>(Set.of(Funcoes.CLIENTE)));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1992, 7, 25, 0, 0), "55555555555", 3L, "https://via.placeholder.com/100", "Lucas", "123", "Souza", "ATIVO","lucas@gmail.com", new HashSet<>(Set.of(Funcoes.CLIENTE)));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1988, 12, 5, 0, 0), "66666666666", 4L, "https://via.placeholder.com/100", "Clara", "123", "Mendes", "ATIVO","clara@gmail.com", new HashSet<>(Set.of(Funcoes.CLIENTE)));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1999, 6, 18, 0, 0), "77777777777", 5L, "https://via.placeholder.com/100", "Diego", "123", "Santos", "ATIVO","diego@gmail.com", new HashSet<>(Set.of(Funcoes.CLIENTE)));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1990, 4, 2, 0, 0), "88888888888", 1L, "https://via.placeholder.com/100", "Rafael", "123", "Pereira", "ATIVO","rafael@gmail.com", new HashSet<>(Set.of(Funcoes.CLIENTE)));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1993, 9, 14, 0, 0), "99999999999", 1L, "https://via.placeholder.com/100", "Beatriz", "123", "Fernandes", "ATIVO","beatriz@gmail.com", new HashSet<>(Set.of(Funcoes.CLIENTE)));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1987, 11, 6, 0, 0), "10101010101", 2L, "https://via.placeholder.com/100", "Fernanda", "123", "Lima", "ATIVO","fernanda@gmail.com", new HashSet<>(Set.of(Funcoes.CLIENTE)));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1994, 2, 28, 0, 0), "12121212121", 2L, "https://via.placeholder.com/100", "Bruno", "123", "Ramos", "ATIVO","bruno@gmail.com", new HashSet<>(Set.of(Funcoes.CLIENTE)));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1991, 12, 12, 0, 0), "13131313131", 3L, "https://via.placeholder.com/100", "Marina", "123", "Barros", "ATIVO","marina@gmail.com", new HashSet<>(Set.of(Funcoes.CLIENTE)));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1989, 7, 3, 0, 0), "14141414141", 3L, "https://via.placeholder.com/100", "Thiago", "123", "Nogueira", "ATIVO","thiago@gmail.com", new HashSet<>(Set.of(Funcoes.CLIENTE)));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1996, 10, 19, 0, 0), "15151515151", 4L, "https://via.placeholder.com/100", "Felipe", "123", "Moura", "ATIVO","felipe@gmail.com", new HashSet<>(Set.of(Funcoes.CLIENTE)));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1997, 3, 8, 0, 0), "16161616161", 4L, "https://via.placeholder.com/100", "Gabriela", "123", "Cardoso", "ATIVO","gabriela@gmail.com", new HashSet<>(Set.of(Funcoes.CLIENTE)));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1986, 6, 30, 0, 0), "17171717171", 5L, "https://via.placeholder.com/100", "Roberto", "123", "Teixeira", "ATIVO","roberto@gmail.com", new HashSet<>(Set.of(Funcoes.CLIENTE)));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1998, 1, 25, 0, 0), "18181818181", 5L, "https://via.placeholder.com/100", "Patrícia", "123", "Gomes", "ATIVO","patricia@gmail.com", new HashSet<>(Set.of(Funcoes.CLIENTE)));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1984, 8, 9, 0, 0), "19191919191", 1L, "https://via.placeholder.com/100", "André", "123", "Ribeiro", "ATIVO","andre@gmail.com", new HashSet<>(Set.of(Funcoes.CLIENTE)));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1992, 5, 5, 0, 0), "20202020202", 2L, "https://via.placeholder.com/100", "Juliana", "123", "Pinto", "ATIVO","juliana@gmail.com", new HashSet<>(Set.of(Funcoes.CLIENTE)));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1990, 1, 2, 0, 0), "20202020202", 1L, "https://via.placeholder.com/100", "Marcelo", "123", "Oliveira", "ATIVO","marcelo20@gmail.com", new HashSet<>(Set.of(Funcoes.CLIENTE)));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1987, 2, 3, 0, 0), "21212121212", 1L, "https://via.placeholder.com/100", "Paula", "123", "Moreira", "ATIVO","paula21@gmail.com", new HashSet<>(Set.of(Funcoes.CLIENTE)));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1993, 3, 4, 0, 0), "22222222223", 2L, "https://via.placeholder.com/100", "Thierry", "123", "Cunha", "ATIVO","thierry22@gmail.com", new HashSet<>(Set.of(Funcoes.CLIENTE)));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1995, 4, 5, 0, 0), "23232323232", 2L, "https://via.placeholder.com/100", "Larissa", "123", "Pereira", "ATIVO","larissa23@gmail.com", new HashSet<>(Set.of(Funcoes.CLIENTE)));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1989, 5, 6, 0, 0), "24242424242", 3L, "https://via.placeholder.com/100", "Gustavo", "123", "Barbosa", "ATIVO","gustavo24@gmail.com", new HashSet<>(Set.of(Funcoes.CLIENTE)));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1991, 6, 7, 0, 0), "25252525252", 3L, "https://via.placeholder.com/100", "Renata", "123", "Alves", "ATIVO","renata25@gmail.com", new HashSet<>(Set.of(Funcoes.CLIENTE)));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1997, 7, 8, 0, 0), "26262626262", 4L, "https://via.placeholder.com/100", "Eduardo", "123", "Melo", "ATIVO","eduardo26@gmail.com", new HashSet<>(Set.of(Funcoes.CLIENTE)));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1992, 8, 9, 0, 0), "27272727272", 4L, "https://via.placeholder.com/100", "Camila", "123", "Azevedo", "ATIVO","camila27@gmail.com", new HashSet<>(Set.of(Funcoes.CLIENTE)));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1988, 9, 10, 0, 0), "28282828282", 5L, "https://via.placeholder.com/100", "Robson", "123", "Cardozo", "ATIVO","robson28@gmail.com", new HashSet<>(Set.of(Funcoes.CLIENTE)));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1994, 10, 11, 0, 0), "29292929292", 5L, "https://via.placeholder.com/100", "Aline", "123", "Vasconcelos", "ATIVO","aline29@gmail.com", new HashSet<>(Set.of(Funcoes.CLIENTE)));
        usuariosService.cadastrarUsuario(LocalDateTime.of(1996, 11, 12, 0, 0), "30303030303", 5L, "https://via.placeholder.com/100", "Bruna", "123", "Falcão", "ATIVO","bruna30@gmail.com", new HashSet<>(Set.of(Funcoes.CLIENTE)));


        // ===================== HORÁRIOS (adicionais para agendamentos) =====================
        horariosService.cadastrarHorario(StatusHorario.AGENDADO, Timestamp.valueOf(LocalDateTime.now().plusDays(2)), Timestamp.valueOf(LocalDateTime.now().plusDays(2).plusHours(1)), LocalDateTime.now(), 1L, 1L, DiasSemana.SEGUNDA);
        horariosService.cadastrarHorario(StatusHorario.AGENDADO, Timestamp.valueOf(LocalDateTime.now().plusDays(3)), Timestamp.valueOf(LocalDateTime.now().plusDays(3).plusHours(1)), LocalDateTime.now(), 1L, 2L, DiasSemana.TERCA);
        horariosService.cadastrarHorario(StatusHorario.AGENDADO, Timestamp.valueOf(LocalDateTime.now().plusDays(4)), Timestamp.valueOf(LocalDateTime.now().plusDays(4).plusHours(1)), LocalDateTime.now(), 2L, 3L, DiasSemana.QUARTA);
        horariosService.cadastrarHorario(StatusHorario.AGENDADO, Timestamp.valueOf(LocalDateTime.now().plusDays(5)), Timestamp.valueOf(LocalDateTime.now().plusDays(5).plusHours(1)), LocalDateTime.now(), 2L, 4L, DiasSemana.QUINTA);
        horariosService.cadastrarHorario(StatusHorario.AGENDADO, Timestamp.valueOf(LocalDateTime.now().plusDays(6)), Timestamp.valueOf(LocalDateTime.now().plusDays(6).plusHours(1)), LocalDateTime.now(), 3L, 5L, DiasSemana.SEXTA);
        horariosService.cadastrarHorario(StatusHorario.CONCLUIDO, Timestamp.valueOf(LocalDateTime.now().minusDays(1)), Timestamp.valueOf(LocalDateTime.now().minusDays(1).plusHours(1)), LocalDateTime.now().minusDays(1), 3L, 6L, DiasSemana.SABADO);
        horariosService.cadastrarHorario(StatusHorario.CANCELADO, Timestamp.valueOf(LocalDateTime.now().minusDays(2)), Timestamp.valueOf(LocalDateTime.now().minusDays(2).plusHours(1)), LocalDateTime.now().minusDays(2), 4L, 7L, DiasSemana.DOMINGO);
        horariosService.cadastrarHorario(StatusHorario.AGENDADO, Timestamp.valueOf(LocalDateTime.now().plusDays(7)), Timestamp.valueOf(LocalDateTime.now().plusDays(7).plusHours(1)), LocalDateTime.now(), 4L, 1L, DiasSemana.SEGUNDA);
        horariosService.cadastrarHorario(StatusHorario.AGENDADO, Timestamp.valueOf(LocalDateTime.now().plusDays(8).plusHours(1)), Timestamp.valueOf(LocalDateTime.now().plusDays(8)), LocalDateTime.now(), 5L, 2L, DiasSemana.TERCA);
        horariosService.cadastrarHorario(StatusHorario.AGENDADO, Timestamp.valueOf(LocalDateTime.now().plusDays(9)), Timestamp.valueOf(LocalDateTime.now().plusDays(9).plusHours(1)), LocalDateTime.now(), 5L, 3L, DiasSemana.QUARTA);
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

        // ===================== GARANTIR QUE USUÁRIOS CADASTRADOS EM SERVIÇOS SÃO FUNCIONÁRIOS NO ESTABELECIMENTO =====================
        // Mapeamento manual baseado nas associações acima:
        // Serviço 1 (Corte simples) -> Estabelecimento 1 (Barber Shop) : usuários 1,2,3
        estabelecimentosService.associarUsuario(1L, 1L);
        estabelecimentosService.associarUsuario(2L, 1L);
        estabelecimentosService.associarUsuario(3L, 1L);

        // Serviço 2 (Barba completa) -> Estabelecimento 1 (Barber Shop) : usuários 4,2
        estabelecimentosService.associarUsuario(4L, 1L);
        estabelecimentosService.associarUsuario(2L, 1L);

        // Serviço 3 (Manicure completa) -> Estabelecimento 2 (Beauty Salon) : usuários 1,5
        estabelecimentosService.associarUsuario(1L, 2L);
        estabelecimentosService.associarUsuario(5L, 2L);

        // Serviço 4 (Tratamento facial) -> Estabelecimento 3 (Spa Facial) : usuário 6
        estabelecimentosService.associarUsuario(6L, 3L);

        // Serviço 5 (Massagem relaxante) -> Estabelecimento 5 (Massagens Relax) : usuário 7
        estabelecimentosService.associarUsuario(7L, 5L);

        // ===================== ASSOCIAÇÃO USUÁRIOS x ESTABELECIMENTOS (GERENTES / FUNCIONÁRIOS) =====================
        estabelecimentosService.associarUsuario(8L, 1L);  // Rafael -> Barber Shop (GERENTE)
        estabelecimentosService.associarUsuario(13L, 1L); // Thiago -> Barber Shop (FUNCIONÁRIO)

        estabelecimentosService.associarUsuario(9L, 2L);  // Beatriz -> Beauty Salon (GERENTE)
        estabelecimentosService.associarUsuario(11L, 2L); // Bruno -> Beauty Salon (FUNCIONÁRIO)

        estabelecimentosService.associarUsuario(12L, 3L); // Marina -> Spa Facial (GERENTE)
        estabelecimentosService.associarUsuario(14L, 3L); // Felipe -> Spa Facial (FUNCIONÁRIO)

        estabelecimentosService.associarUsuario(16L, 4L); // Roberto -> Clínica Corpo & Saúde (GERENTE)
        estabelecimentosService.associarUsuario(15L, 4L); // Gabriela -> Clínica Corpo & Saúde (FUNCIONÁRIO)

        estabelecimentosService.associarUsuario(17L, 5L); // Patrícia -> Massagens Relax (GERENTE)
        estabelecimentosService.associarUsuario(19L, 5L); // Juliana -> Massagens Relax (FUNCIONÁRIO)

        estabelecimentosService.associarUsuario(20L, 6L); // Manager -> Estab 6
        estabelecimentosService.associarUsuario(21L, 6L); // Func -> Estab 6

        estabelecimentosService.associarUsuario(22L, 7L); // Manager -> Estab 7
        estabelecimentosService.associarUsuario(23L, 7L); // Func -> Estab 7

        estabelecimentosService.associarUsuario(24L, 8L); // Manager -> Estab 8
        estabelecimentosService.associarUsuario(25L, 8L); // Func -> Estab 8

        estabelecimentosService.associarUsuario(26L, 9L); // Manager -> Estab 9
        estabelecimentosService.associarUsuario(27L, 9L); // Func -> Estab 9

        estabelecimentosService.associarUsuario(28L, 10L); // Manager -> Estab 10
        estabelecimentosService.associarUsuario(29L, 10L); // Func -> Estab 10

        int dayOffset = 2; // começa em +2 dias para não colidir com existentes
        for (long userId = 20L; userId <= 29L; userId++) {
            long estabId = switch ((int) userId) {
                case 20,21 -> 6L;
                case 22,23 -> 7L;
                case 24,25 -> 8L;
                case 26,27 -> 9L;
                case 28,29 -> 10L;
                default -> 6L;
            };


            horariosService.cadastrarHorario(StatusHorario.AGENDADO, Timestamp.valueOf(LocalDateTime.now().plusDays(dayOffset)), Timestamp.valueOf(LocalDateTime.now().plusDays(dayOffset).plusHours(1)), LocalDateTime.now(), estabId, userId, DiasSemana.SEGUNDA);
            horariosService.cadastrarHorario(StatusHorario.AGENDADO, Timestamp.valueOf(LocalDateTime.now().plusDays(dayOffset+1)), Timestamp.valueOf(LocalDateTime.now().plusDays(dayOffset+1).plusHours(1)), LocalDateTime.now(), estabId, userId, DiasSemana.TERCA);
            horariosService.cadastrarHorario(StatusHorario.AGENDADO, Timestamp.valueOf(LocalDateTime.now().plusDays(dayOffset+2)), Timestamp.valueOf(LocalDateTime.now().plusDays(dayOffset+2).plusHours(1)), LocalDateTime.now(), estabId, userId, DiasSemana.QUARTA);
            horariosService.cadastrarHorario(StatusHorario.AGENDADO, Timestamp.valueOf(LocalDateTime.now().plusDays(dayOffset+3)), Timestamp.valueOf(LocalDateTime.now().plusDays(dayOffset+3).plusHours(1)), LocalDateTime.now(), estabId, userId, DiasSemana.QUINTA);


            dayOffset += 1; // avança um dia a cada usuário para variar
        }

        // ===================== AGENDAMENTOS (seed) =====================
        // OBS: Os IDs de usuários/horários/serviços considerados seguem a ordem de inserção acima.
        // Ajuste caso seu banco gere IDs diferentes. Aqui usamos horários recém-criados (últimos 10).

        // Agendamentos para alguns dos novos usuários
        agendamentosService.criarAgendamento(1L, 1L, 8L, 1L, 6L, LocalDateTime.now().minusHours(2), StatusHorario.AGENDADO, "Primeiro agendamento do Rafael");
        agendamentosService.criarAgendamento(2L, 1L, 9L, 2L, 7L, LocalDateTime.now().minusDays(1), StatusHorario.AGENDADO, "Agendamento da Beatriz");
        agendamentosService.criarAgendamento(3L, 2L, 10L, 3L, 8L, LocalDateTime.now().minusDays(2), StatusHorario.AGENDADO, "Agendamento da Fernanda");
        agendamentosService.criarAgendamento(4L, 2L, 11L, 4L, 9L, LocalDateTime.now().minusDays(3), StatusHorario.AGENDADO, "Agendamento do Bruno");
        agendamentosService.criarAgendamento(5L, 3L, 12L, 5L, 10L, LocalDateTime.now().minusDays(4), StatusHorario.AGENDADO, "Agendamento da Marina");
        agendamentosService.criarAgendamento(1L, 1L, 13L, 1L, 1L, LocalDateTime.now().minusDays(5), StatusHorario.CONCLUIDO, "Agendamento do Thiago - concluído");
        agendamentosService.criarAgendamento(2L, 1L, 14L, 2L, 2L, LocalDateTime.now().minusDays(6), StatusHorario.CANCELADO, "Agendamento do Felipe - cancelado");
        agendamentosService.criarAgendamento(3L, 2L, 15L, 3L, 3L, LocalDateTime.now().minusDays(7), StatusHorario.CONCLUIDO, "Agendamento da Gabriela - concluído");
        agendamentosService.criarAgendamento(5L, 5L, 16L, 7L, 4L, LocalDateTime.now().minusDays(8), StatusHorario.AGENDADO, "Agendamento do Roberto");
        agendamentosService.criarAgendamento(6L, 5L, 17L, 6L, 5L, LocalDateTime.now().minusDays(9), StatusHorario.AGENDADO, "Agendamento da Patrícia");
        agendamentosService.criarAgendamento(4L, 4L, 18L, 4L, 8L, LocalDateTime.now().minusDays(10), StatusHorario.AGENDADO, "Agendamento do André");
        agendamentosService.criarAgendamento(7L, 2L, 19L, 5L, 9L, LocalDateTime.now().minusDays(11), StatusHorario.AGENDADO, "Agendamento da Juliana");

        System.out.println("Seed inicial expandido inserido com sucesso!");
    }
}
