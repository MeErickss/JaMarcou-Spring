package com.example.demo.service;

import com.example.demo.model.Categorias;
import com.example.demo.model.Estabelecimentos;
import com.example.demo.model.Locais;
import com.example.demo.repository.EstabelecimentosRepository;
import com.example.demo.repository.LocaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocaisService {

    @Autowired
    private LocaisRepository locaisRepository;

    @Autowired
    private EstabelecimentosRepository estabelecimentosRepository;

    // Listar todos
    public List<Locais> listAllLocais() {
        return locaisRepository.findAll();
    }

    // Buscar por ID
    public Optional<Locais> getLocalById(Long id) {
        return locaisRepository.findById(id);
    }

    public void criarLocal(Integer numero, String cep, String rua, String complemento, Double coordenadas){

        Locais local = new Locais();
        local.setCep(cep);
        local.setComplemento(complemento);
        local.setCoordenadas(coordenadas);
        local.setRua(rua);
        local.setNumero(numero);
        locaisRepository.save(local);
    }
}
