package com.example.demo.repository;

import com.example.demo.model.Agendamentos;
import com.example.demo.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

    // Exemplos de consultas customizadas (se precisar)
    Usuarios findByEmail(String email);

}
