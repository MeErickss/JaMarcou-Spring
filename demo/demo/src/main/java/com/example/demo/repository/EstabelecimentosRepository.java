package com.example.demo.repository;

import com.example.demo.model.Estabelecimentos;
import com.example.demo.model.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstabelecimentosRepository extends JpaRepository<Estabelecimentos, Long> {

    Estabelecimentos findByNome(String nome);
    Estabelecimentos findBySenha(String senha);

}
