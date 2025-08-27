package com.example.demo.repository;

import com.example.demo.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

    // Exemplos de consultas customizadas (se precisar)
    Usuarios findByCpf(String cpf);
    Usuarios findByEmail(String email);
}
