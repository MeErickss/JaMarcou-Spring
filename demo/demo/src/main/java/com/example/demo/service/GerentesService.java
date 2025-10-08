package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GerentesService {

    @Autowired
    private GerentesRepository gerentesRepository;

    @Autowired
    private EstabelecimentosRepository estabelecimentosRepository;

    private final PasswordEncoder encoder = new BCryptPasswordEncoder();

    public Gerentes createGerente(String email,
                                  String nome,
                                  String sobrenome,
                                  String cpf,
                                  String senha,
                                  LocalDateTime dataNascimento,
                                  String linkImg,
                                  String statusUsuario,
                                  Long estabelecimentoId,
                                  String telefone) {

        Estabelecimentos e = estabelecimentosRepository.findById(estabelecimentoId)
                .orElseThrow(() -> new IllegalArgumentException("Estabelecimento não encontrado: " + estabelecimentoId));

        Gerentes g = new Gerentes();
        g.setEmail(email);
        g.setNome(nome);
        g.setSobrenome(sobrenome);
        g.setCpf(cpf);

        String hashed = encoder.encode(senha);

        g.setSenha(hashed);
        g.setDataNascimento(dataNascimento);
        g.setLinkImagem(linkImg);
        g.setStatusUsuario(statusUsuario);
        g.setTelefone(telefone);

        g.setEstabelecimento(e);

        Gerentes salvo = gerentesRepository.save(g);
        e.getGerentes().add(salvo);
        estabelecimentosRepository.save(e);
        return salvo;
    }
}
