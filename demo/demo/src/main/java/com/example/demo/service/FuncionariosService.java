package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FuncionariosService {

    @Autowired
    private FuncionariosRepository funcionariosRepository;

    @Autowired
    private EstabelecimentosRepository estabelecimentosRepository;

    /**
     * Cria novo Funcionarios (dados pessoais + vínculo com estabelecimento + datas contrato).
     */
    public Funcionarios createFuncionario(String email,
                                          String nome,
                                          String sobrenome,
                                          String cpf,
                                          String senha,
                                          LocalDateTime dataNascimento,
                                          String linkImg,
                                          String statusUsuario,
                                          Long estabelecimentoId,
                                          LocalDateTime dataInicioContrato,
                                          LocalDateTime dataFimContrato,
                                          String telefone) {

        Estabelecimentos e = estabelecimentosRepository.findById(estabelecimentoId)
                .orElseThrow(() -> new IllegalArgumentException("Estabelecimento não encontrado: " + estabelecimentoId));

        Funcionarios f = new Funcionarios();
        // setters herdados de PessoaFisica (certifique-se que existem)
        f.setEmail(email);
        f.setNome(nome);
        f.setSobrenome(sobrenome);
        f.setCpf(cpf);
        f.setSenha(senha);
        f.setDataNascimento(dataNascimento);
        f.setLinkImagem(linkImg);
        f.setStatusUsuario(statusUsuario);
        f.setTelefone(telefone);

        f.setEstabelecimento(e);
        f.setDataInicioContrato(dataInicioContrato);
        f.setDataFimContrato(dataFimContrato);

        Funcionarios salvo = funcionariosRepository.save(f);
        e.getFuncionarios().add(salvo);
        estabelecimentosRepository.save(e);
        return salvo;
    }
}
