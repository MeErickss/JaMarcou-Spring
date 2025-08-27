package com.example.demo.repository;

import com.example.demo.model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long> {

    Categorias findByDescricao(String descricao);
    Categorias findByNome(String nome);
}
