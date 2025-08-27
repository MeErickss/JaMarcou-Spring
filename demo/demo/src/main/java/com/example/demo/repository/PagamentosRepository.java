package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentosRepository extends JpaRepository<Pagamentos, Long> {

    Pagamentos findByValor(Float valor);
}
