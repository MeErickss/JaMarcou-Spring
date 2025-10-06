package com.example.demo.service;

import com.example.demo.dto.CategoriasDto;
import com.example.demo.model.Categorias;
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

    public void cadastrarCategoria(String descricao, String nome){

        Categorias categoria = new Categorias();
        categoria.setDescricao(descricao);
        categoria.setNome(nome);
        categoriasRepository.save(categoria);
    }

    public void cadastrarCategoria(CategoriasDto dto){

        Categorias categoria = new Categorias();
        categoria.setDescricao(dto.getDescricao());
        categoria.setNome(dto.getNome());
        categoriasRepository.save(categoria);
    }

    public void atualizarCategoria(CategoriasDto dto){

        Categorias categoria = categoriasRepository.getReferenceById(dto.getId());
        categoria.setDescricao(dto.getDescricao());
        categoria.setNome(dto.getNome());
        categoriasRepository.save(categoria);
    }

    public void deletarCategoria(Long id){
        Categorias c = categoriasRepository.getReferenceById(id);
        categoriasRepository.delete(c);
    }
}
