package com.example.demo.repository;

import com.example.demo.model.Categorias;
import com.example.demo.model.Estabelecimentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstabelecimentosRepository extends JpaRepository<Estabelecimentos, Long> {

    Estabelecimentos findByNome(String nome);
    Estabelecimentos findBySenha(String senha);

    @Query("SELECT DISTINCT e FROM Estabelecimentos e LEFT JOIN FETCH e.usuarios")
    List<Estabelecimentos> findAllWithUsuarios();

    @Query("SELECT DISTINCT e FROM Estabelecimentos e " +
            "JOIN e.usuarios u " +
            "JOIN u.funcoes f " +
            "WHERE u.id = :userId AND f = com.example.demo.model.enumeration.Funcoes.GERENTE")
    List<Estabelecimentos> findEstabelecimentosOndeUsuarioEhGerente(@Param("userId") Long userId);

}
