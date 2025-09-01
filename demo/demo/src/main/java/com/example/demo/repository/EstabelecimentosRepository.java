package com.example.demo.repository;

import com.example.demo.model.Categorias;
import com.example.demo.model.Estabelecimentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstabelecimentosRepository extends JpaRepository<Estabelecimentos, Long> {

    Estabelecimentos findByNome(String nome);
    Estabelecimentos findBySenha(String senha);

    @Query("SELECT DISTINCT e FROM Estabelecimentos e LEFT JOIN FETCH e.usuarios")
    List<Estabelecimentos> findAllWithUsuarios();

}
