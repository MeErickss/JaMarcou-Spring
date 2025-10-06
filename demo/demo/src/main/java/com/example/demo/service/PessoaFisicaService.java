package com.example.demo.service;

import com.example.demo.model.PessoaFisica;
import com.example.demo.repository.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PessoaFisicaService {

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    public PessoaFisica createPessoaFisica(String email,
                                           String nome,
                                           String sobrenome,
                                           String cpf,
                                           String senha,
                                           LocalDateTime dataNascimento,
                                           String linkImg,
                                           String statusUsuario) {
        PessoaFisica p = new PessoaFisica();
        p.setEmail(email);
        p.setNome(nome);
        p.setSobrenome(sobrenome);
        p.setCpf(cpf);
        p.setSenha(senha);
        p.setDataNascimento(dataNascimento);
        p.setLinkImagem(linkImg);
        p.setStatusUsuario(statusUsuario);
        return pessoaFisicaRepository.save(p);
    }
}
