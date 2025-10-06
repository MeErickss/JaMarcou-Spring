package com.example.demo.repository;

import com.example.demo.model.Locais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocaisRepository extends JpaRepository<Locais, Long> {

    Locais findByRua(String rua);
}
