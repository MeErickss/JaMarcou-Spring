package com.example.demo.service;

import com.example.demo.model.Clientes;
import com.example.demo.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository clientesRepository;

    /**
     * Cria um cliente (herda PessoaFisica). Passa os dados pessoais diretamente.
     */
    public Clientes createCliente(String email,
                                  String nome,
                                  String sobrenome,
                                  String cpf,
                                  String senha,
                                  LocalDateTime dataNascimento,
                                  String linkImg,
                                  String telefone,
                                  String statusUsuario) {

        Clientes c = new Clientes();
        c.setEmail(email);
        c.setNome(nome);
        c.setSobrenome(sobrenome);
        c.setCpf(cpf);
        c.setSenha(senha);
        c.setDataNascimento(dataNascimento);
        c.setLinkImagem(linkImg);
        c.setStatusUsuario(statusUsuario);
        c.setTelefone(telefone);

        return clientesRepository.save(c);
    }
}
