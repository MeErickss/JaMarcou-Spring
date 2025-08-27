package com.example.demo.service;

import com.example.demo.model.Avaliacoes;
import com.example.demo.model.Categorias;
import com.example.demo.model.Estabelecimentos;
import com.example.demo.model.Horarios;
import com.example.demo.repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriasService {

    @Autowired
    private CategoriasRepository categoriasRepository;

    public List<Categorias> listAllCategorias() {
        return categoriasRepository.findAll();
    }

    // Buscar por ID
    public Optional<Categorias> getCategoriaById(Long id) {
        return categoriasRepository.findById(id);
    }

    public void criarCategoria(String descricao, String nome){

        Categorias categoria = new Categorias();
        categoria.setDescricao(descricao);
        categoria.setNome(nome);
        categoriasRepository.save(categoria);
    }
}
